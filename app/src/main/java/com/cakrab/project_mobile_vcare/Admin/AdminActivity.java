package com.cakrab.project_mobile_vcare.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cakrab.project_mobile_vcare.LoginActivity;
import com.cakrab.project_mobile_vcare.R;

public class AdminActivity extends AppCompatActivity {

    Button buttonAddNews, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        init();
        setAction();
    }

    public void init() {
        buttonAddNews = findViewById(R.id.button_add_news);
        btnLogout = findViewById(R.id.btnLogout);
    }

    private void setAction() {

        buttonAddNews.setOnClickListener(view -> {
            Intent i = new Intent(AdminActivity.this, CreateNewsActivity.class);
            startActivity(i);
        });

        btnLogout.setOnClickListener(view -> {
            Intent logout = new Intent(AdminActivity.this, LoginActivity.class);
            startActivity(logout);
        });
    }
}