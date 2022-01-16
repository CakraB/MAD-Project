package com.cakrab.project_mobile_vcare.Admin.News;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cakrab.project_mobile_vcare.Adapter.NewsAdapter;
import com.cakrab.project_mobile_vcare.Model.News;
import com.cakrab.project_mobile_vcare.R;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    RecyclerView newsRV;
    ArrayList<News> newsList;
    NewsAdapter newsAdapter;
    Button buttonAddNews;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        buttonAddNews = findViewById(R.id.button_add_news);
        newsRV = findViewById(R.id.newsRV);
        db = FirebaseFirestore.getInstance();
        // Arraylist
        newsList = new ArrayList<>();
        newsRV.setHasFixedSize(true);
        newsRV.setLayoutManager(new GridLayoutManager(NewsActivity.this, 1));
        // Set Adapter
        newsAdapter = new NewsAdapter(NewsActivity.this, newsList);
        newsRV.setAdapter(newsAdapter);
        // Retrieve Data from Firestore
        db.collection("news")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot documentSnapshot : list) {
                            News news = documentSnapshot.toObject(News.class);
                            if (news != null) {
                                news.setId(documentSnapshot.getId());
                            }
                            newsList.add(news);
                        }
                        newsAdapter.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Fail to get data", Toast.LENGTH_SHORT).show());

        buttonAddNews.setOnClickListener(view -> {
            Intent i = new Intent(NewsActivity.this, CreateNewsActivity.class);
            startActivity(i);
        });
    }
}