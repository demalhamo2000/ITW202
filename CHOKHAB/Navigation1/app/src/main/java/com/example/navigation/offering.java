package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.zip.Inflater;

public class offering extends AppCompatActivity {
    WebView webView;
    public String fileName = "Offering.html";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offering);
        webView = (WebView) findViewById(R.id.webView);

        WebSettings ws = webView.getSettings();

        webView.loadUrl("file:///android_asset/Offering.html");

    }

}