package com.cakrab.project_mobile_vcare.Admin.News;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cakrab.project_mobile_vcare.Adapter.NewsAdapter;
import com.cakrab.project_mobile_vcare.Model.News;
import com.cakrab.project_mobile_vcare.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

public class CreateNewsActivity extends AppCompatActivity {

    NewsAdapter newsAdapter;
    EditText editNewsTitle, editNewsDesc, editNewsImage;
    Button buttonAddNews;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_news);
        init();
        setAction();
    }

    public void init() {
        editNewsTitle = findViewById(R.id.edit_news_title);
        editNewsDesc = findViewById(R.id.edit_news_desc);
        editNewsImage = findViewById(R.id.edit_news_image);
        buttonAddNews = findViewById(R.id.button_submit_news);
        db = FirebaseFirestore.getInstance();
    }

    public void setAction() {
        buttonAddNews.setOnClickListener(view -> {
            String newsTitle = editNewsTitle.getText().toString();
            String newsDesc = editNewsDesc.getText().toString();
            String newsImage = editNewsImage.getText().toString();

            if (TextUtils.isEmpty(newsTitle)) {
                editNewsTitle.setError("Please enter News Name");
            } else if (TextUtils.isEmpty(newsDesc)) {
                editNewsDesc.setError("Please enter News Description");
            } else if (TextUtils.isEmpty(newsImage)) {
                editNewsImage.setError("Please enter News URL Image");
            } else {
                addNews(newsTitle, newsDesc, newsImage);
            }
        });

        // Cara Aslab
//        buttonAddNews.setOnClickListener(view -> {
//            String newsTitle = editNewsTitle.getText().toString();
//            String newsDesc = (editNewsDesc.getText().toString().isEmpty()) ? null : editNewsDesc.getText().toString();
//            String newsImage = editNewsImage.getText().toString();
//
//            Map<String, Object> newsData = new HashMap<>();
//            newsData.put("title", newsTitle);
//            newsData.put("description", newsDesc);
//            newsData.put("image", newsImage);
//            // Add to Adapter for Arraylist
////            newsAdapter.getList().add(new News(newsTitle, newsDesc, newsImage));
////            newsAdapter.notifyDataSetChanged();
//            // Add news to Firebase Firestore
//            db.collection("news").document(newsTitle).set(newsData);
//            Toast.makeText(CreateNewsActivity.this, "News Create Successfully", Toast.LENGTH_SHORT).show();
//
//            Intent back = new Intent(this, NewsActivity.class);
//            startActivity(back);
//        });
    }

    private void addNews(String newsTitle, String newsDesc, String newsImage) {
        CollectionReference dbNews = db.collection("news");
        News news = new News(newsTitle, newsDesc, newsImage);
        dbNews.add(news).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Your News has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
                Intent back = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(back);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(getApplicationContext(), "Fail to add news \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }
}