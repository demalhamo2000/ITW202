package com.example.navigation.ui.gallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
//import android.webkit.WebView;

import com.example.navigation.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class TnCFragment extends Fragment implements View.OnClickListener{
    WebView webView;
    public String fileName = "Terms_condition.html";

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public TnCFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment TnCFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static TnCFragment newInstance(String param1, String param2) {
//        TnCFragment fragment = new TnCFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button Agree;
        Button Disagree;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_tn_c, container, false);
        View view = inflater.inflate(R.layout.fragment_tn_c, container, false);

        webView = (WebView) view.findViewById(R.id.webView);

        WebSettings ws = webView.getSettings();

        webView.loadUrl("file:///android_asset/Terms_condition.html");

        Agree = (Button)view.findViewById(R.id.Agree);
        Agree.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                GalleryFragment firstFragment = new GalleryFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.drawer_layout,firstFragment);
                transaction.commit();
            }
        });
        return view;


    }

    @Override
    public void onClick(View v) {
//        switch (R.id.)

    }
}