package com.cakrab.project_mobile_vcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvArticles;
    private ArrayList<News> newsArrayList;
    private NewsAdapter newsAdapter;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        rvArticles = findViewById(R.id.rvContent);
        newsArrayList = new ArrayList<>();
        newsAdapter = new NewsAdapter(newsArrayList, this);
        rvArticles.setLayoutManager(new LinearLayoutManager(this));
        rvArticles.setAdapter(newsAdapter);

        newsArrayList.add(new News(
                "Mobil",
                "Mobil bla bla bla",
                "10/11/2021"
        ));
        newsArrayList.add(new News(
                "Motor",
                "Motor bla bla bla",
                "10/11/2021"
        ));
        newsArrayList.add(new News(
                "Mobil",
                "Mobil bla bla bla",
                "10/11/2021"
        ));
        newsArrayList.add(new News(
                "Motor",
                "Motor bla bla bla",
                "10/11/2021"
        ));
        newsArrayList.add(new News(
                "Mobil",
                "Mobil bla bla bla",
                "10/11/2021"
        ));
        newsArrayList.add(new News(
                "Motor",
                "Motor bla bla bla",
                "10/11/2021"
        ));
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                    int navId = item.getItemId();

                    return true;
                }
            };
}