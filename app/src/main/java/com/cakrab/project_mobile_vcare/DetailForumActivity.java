package com.cakrab.project_mobile_vcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailForumActivity extends AppCompatActivity {

    TextView textName, textDesc, textDate;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_forum);

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