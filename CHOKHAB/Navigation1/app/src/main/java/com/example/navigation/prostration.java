package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class prostration extends AppCompatActivity {
    WebView webView;
    public String fileName = "Prostrate.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prostration);

        webView = (WebView) findViewById(R.id.webView1);

        WebSettings ws = webView.getSettings();

        webView.loadUrl("file:///android_asset/Prostrate.html");
    }
}