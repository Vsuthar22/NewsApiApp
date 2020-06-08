package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {

    TextView tvtitle,tvdescription,tvsource;
    ImageView imageView;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvtitle = findViewById(R.id.tvtitle);
        tvsource = findViewById(R.id.tvsource);
        tvdescription = findViewById(R.id.desc);
        //date = itemView.findViewById(R.id.tvdate);
        imageView = findViewById(R.id.imgview);
        webView = findViewById(R.id.webView);


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String source = intent.getStringExtra("source");
        String desc = intent.getStringExtra("desc");
        String urltoImage = intent.getStringExtra("imageUrl");
        String url = intent.getStringExtra("url");


        tvtitle.setText(title);
        tvdescription.setText(desc);
        tvsource.setText(source);
        Picasso.get().load(urltoImage).into(imageView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);






    }
}
