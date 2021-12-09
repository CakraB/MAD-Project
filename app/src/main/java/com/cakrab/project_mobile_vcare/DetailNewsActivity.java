package com.cakrab.project_mobile_vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailNewsActivity extends AppCompatActivity {

    TextView textName, textDesc, textDate;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        textName = findViewById(R.id.text_content_name);
        textDesc = findViewById(R.id.text_content_desc);
        textDate = findViewById(R.id.text_content_date);
        imageView = findViewById(R.id.image_content);

        Intent getNews = getIntent();
        String getNewsName = getNews.getStringExtra("NAME");
        String getNewsDesc = getNews.getStringExtra("DESC");
        String getNewsDate = getNews.getStringExtra("DATE");

        textName.setText(getNewsName);
        textDesc.setText(getNewsDesc);
        textDate.setText(getNewsDate);
    }
}