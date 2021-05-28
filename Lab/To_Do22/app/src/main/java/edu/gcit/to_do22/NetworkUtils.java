package edu.gcit.to_do22;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();
    //base url for book API
    private static final String BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes?";
    //parameter for the search string
    private static final String QUERY_PARAM = "q";
    //parameter that limit the search result
    private static final String MAX_RESULTS = "maxResults";
    //parameter to filter by printType
    private static final String PRINT_TYPE = "printType";

    static String getBookInfo(String queryString){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String bookJSONString = null;



        try {
            Uri builtURI = Uri.parse(BOOK_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, queryString)
                    .appendQueryParameter(MAX_RESULTS, "10")
                    .appendQueryParameter(PRINT_TYPE, "Books")
                    .build();
            URL requestURL = new URL(builtURI.toString());
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            //get the inputStream
            InputStream inputStream = urlConnection.getInputStream();
            //create a buffered reader from input stream
            reader = new BufferedReader(new InputStreamReader(inputStream));
            //use a StringBuilder to hold the incoming response
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null){
                builder.append(line);
                //Since its JSON, adding a newline isn't necessary(it)
                builder.append("\n");
            }
            if (builder.length() == 0){
                //Stream was empty. NO point in prasing.
                return null;
            }
            bookJSONString = builder.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (urlConnection != null){
                urlConnection.disconnect();
            }
            if (reader != null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
        Log.d(LOG_TAG, bookJSONString);
        return bookJSONString;
    }

}
