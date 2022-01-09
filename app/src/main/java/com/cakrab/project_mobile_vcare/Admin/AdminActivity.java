package com.cakrab.project_mobile_vcare.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cakrab.project_mobile_vcare.Admin.Garage.GarageActivity;
import com.cakrab.project_mobile_vcare.Admin.News.NewsActivity;
import com.cakrab.project_mobile_vcare.Auth.LoginActivity;
import com.cakrab.project_mobile_vcare.R;

public class AdminActivity extends AppCompatActivity {

    Button buttonNews, buttonGarage, buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        init();
        setAction();
    }

    public void init() {
        buttonNews = findViewById(R.id.button_news);
        buttonGarage = findViewById(R.id.button_garage);
        buttonLogout = findViewById(R.id.button_logout);
    }

    private void setAction() {

        buttonNews.setOnClickListener(view -> {
            Intent news = new Intent(AdminActivity.this, NewsActivity.class);
            startActivity(news);
        });

        buttonGarage.setOnClickListener(view -> {
            Intent garage = new Intent(AdminActivity.this, GarageActivity.class);
            startActivity(garage);
        });

        buttonLogout.setOnClickListener(view -> {
            Intent logout = new Intent(AdminActivity.this, LoginActivity.class);
            startActivity(logout);
        });
    }
}