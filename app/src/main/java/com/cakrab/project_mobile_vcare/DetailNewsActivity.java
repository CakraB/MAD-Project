package com.cakrab.project_mobile_vcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cakrab.project_mobile_vcare.Admin.News.EditNewsActivity;
import com.squareup.picasso.Picasso;

public class DetailNewsActivity extends AppCompatActivity {

    TextView textName, textDesc, textDate;
    Button buttonEdit;
    ImageView imageView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        textName = findViewById(R.id.text_content_name);
        textDesc = findViewById(R.id.text_content_desc);
        textDate = findViewById(R.id.text_content_date);
        imageView = findViewById(R.id.image_content);
        buttonEdit = findViewById(R.id.button_item_edit);

        Intent getNews = getIntent();
        String getNewsId = getNews.getStringExtra("ID");
        String getNewsName = getNews.getStringExtra("NAME");
        String getNewsDesc = getNews.getStringExtra("DESC");
        String getNewsImage = getNews.getStringExtra("IMAGE");

        textName.setText(getNewsName);
        textDesc.setText(getNewsDesc);
        if (getNewsImage != null) {
            Picasso.get().load(getNewsImage).into(imageView);
        } else {
            Picasso.get().load(R.drawable.ic_launcher_background).into(imageView);
        }

        // SharedPreference
        sharedPreferences = this.getSharedPreferences("REMEMBER", Context.MODE_PRIVATE);
        String getData = sharedPreferences.getString("EMAIL", "");

        if (getData.equals("admin@gmail.com")) {
            buttonEdit.setVisibility(View.VISIBLE);

            buttonEdit.setOnClickListener(view -> {
                Intent i = new Intent(this, EditNewsActivity.class);
                i.putExtra("ID", getNewsId);
                i.putExtra("NAME", getNewsName);
                i.putExtra("DESC", getNewsDesc);
                i.putExtra("IMAGE", getNewsImage);
                startActivity(i);
            });
        } else {
            buttonEdit.setVisibility(View.INVISIBLE);
        }
    }
}