package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ritual extends AppCompatActivity {
    WebView webView;
    public String fileName = "Ritual.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ritual);

        webView = (WebView) findViewById(R.id.webView3);

        WebSettings ws = webView.getSettings();

        webView.loadUrl("file:///android_asset/Ritual.html");
    }
}