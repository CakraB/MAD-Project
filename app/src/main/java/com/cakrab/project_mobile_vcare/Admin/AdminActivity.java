package com.cakrab.project_mobile_vcare.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cakrab.project_mobile_vcare.Auth.LoginActivity;
import com.cakrab.project_mobile_vcare.Admin.News.NewsActivity;
import com.cakrab.project_mobile_vcare.R;

public class AdminActivity extends AppCompatActivity {

    Button buttonNews, buttonGarage, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        init();
        setAction();
    }

    public void init() {
        buttonNews = findViewById(R.id.button_news);
        buttonGarage = findViewById(R.id.button_garege);
        btnLogout = findViewById(R.id.btnLogout);
    }

    private void setAction() {

        buttonNews.setOnClickListener(view -> {
            Intent i = new Intent(AdminActivity.this, NewsActivity.class);
            startActivity(i);
        });

        buttonGarage.setOnClickListener(view -> {
            Intent i = new Intent(AdminActivity.this, NewsActivity.class);
            startActivity(i);
        });

        btnLogout.setOnClickListener(view -> {
            Intent logout = new Intent(AdminActivity.this, LoginActivity.class);
            startActivity(logout);
        });
    }
}