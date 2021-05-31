package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class prayer extends AppCompatActivity {
    WebView webView;
    public String fileName = "Prayer.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer);

        webView = (WebView) findViewById(R.id.webView2);

        WebSettings ws = webView.getSettings();

        webView.loadUrl("file:///android_asset/Prayer.html");
    }
}