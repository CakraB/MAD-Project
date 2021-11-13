package com.cakrab.project_mobile_vcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvArticles;
    private ProgressBar pbLoading;
    private ArrayList<News> newsArrayList;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rvArticles = findViewById(R.id.rvContent);
        pbLoading = findViewById(R.id.pbLoading);
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
    }
}