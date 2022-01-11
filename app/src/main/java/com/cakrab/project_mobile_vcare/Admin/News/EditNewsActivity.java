package com.cakrab.project_mobile_vcare.Admin.News;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cakrab.project_mobile_vcare.Model.News;
import com.cakrab.project_mobile_vcare.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

public class EditNewsActivity extends AppCompatActivity {

    EditText editNewsTitle, editNewsDesc, editNewsImage;
    Button buttonUpdateNews, buttonDeleteNews;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_news);
        init();
        setAction();
    }

    public void init() {
        editNewsTitle = findViewById(R.id.edit_news_title);
        editNewsDesc = findViewById(R.id.edit_news_desc);
        editNewsImage = findViewById(R.id.edit_news_image);
        buttonUpdateNews = findViewById(R.id.button_update_news);
        buttonDeleteNews = findViewById(R.id.button_delete_news);
        db = FirebaseFirestore.getInstance();
    }

    public void setAction() {
        Intent getNews = getIntent();
        String getNewsId = getNews.getStringExtra("ID");
        String getNewsName = getNews.getStringExtra("NAME");
        String getNewsDesc = getNews.getStringExtra("DESC");
        String getNewsImage = getNews.getStringExtra("IMAGE");

        Log.d("ID", getNewsId);
        Log.d("TITLE", getNewsName);
        Log.d("DESC", getNewsDesc);
        Log.d("IMAGE URL", getNewsImage);

        editNewsTitle.setText(getNewsName);
        editNewsDesc.setText(getNewsDesc);
        editNewsImage.setText(getNewsImage);

        buttonUpdateNews.setOnClickListener(view -> {
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
                updateNews(getNewsId, newsTitle, newsDesc, newsImage);
            }
        });

        buttonDeleteNews.setOnClickListener(view -> {
            deleteNews(getNewsId);
        });

    }

    private void updateNews(String newsId, String newsTitle, String newsDesc, String newsImage) {
        News updateNews = new News(newsTitle, newsDesc, newsImage);
        db.collection("news").
                document(newsId).
                set(updateNews).
                addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(EditNewsActivity.this, "News has been updated..", Toast.LENGTH_SHORT).show();
                        Intent back = new Intent(getApplicationContext(), NewsActivity.class);
                        startActivity(back);
                    }
                }).
                addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Toast.makeText(EditNewsActivity.this, "Fail to update the data..", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void deleteNews(String newsId) {
        db.collection("news").
                document(newsId).
                delete().
                addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(EditNewsActivity.this, "News has been deleted from Database.", Toast.LENGTH_SHORT).show();
                            Intent back = new Intent(getApplicationContext(), NewsActivity.class);
                            startActivity(back);
                        } else {
                            Toast.makeText(EditNewsActivity.this, "Fail to delete the news. ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}