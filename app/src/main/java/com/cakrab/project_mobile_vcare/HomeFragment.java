package com.cakrab.project_mobile_vcare;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cakrab.project_mobile_vcare.Adapter.NewsAdapter;
import com.cakrab.project_mobile_vcare.Model.News;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    TextView textEmail;
    RecyclerView newsRV;
    ArrayList<News> newsList;
    NewsAdapter newsAdapter;
    SharedPreferences sharedPreferences;
    boolean isRemember = false;
    FirebaseFirestore db;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Init
        newsRV = view.findViewById(R.id.newsRV);
        textEmail = view.findViewById(R.id.text_email);
        db = FirebaseFirestore.getInstance();
        // SharedPreference
        sharedPreferences = this.getActivity().getSharedPreferences("REMEMBER", Context.MODE_PRIVATE);
        isRemember = sharedPreferences.getBoolean("CHECKBOX", false);
        String getData = sharedPreferences.getString("EMAIL", "");
        textEmail.setText(getData);
        // Arraylist
        newsList = new ArrayList<>();
        newsRV.setHasFixedSize(true);
        newsRV.setLayoutManager(new GridLayoutManager(getContext(), 1));
        // Set Adapter
        newsAdapter = new NewsAdapter(getContext(), newsList);
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
                .addOnFailureListener(e -> Toast.makeText(getContext(), "Fail to get data", Toast.LENGTH_SHORT).show());
    }
}
