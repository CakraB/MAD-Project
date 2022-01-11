package com.cakrab.project_mobile_vcare;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

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
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot documentSnapshot : list) {
                                News news = documentSnapshot.toObject(News.class);
                                news.setId(documentSnapshot.getId());
                                newsList.add(news);
                            }
                            newsAdapter.notifyDataSetChanged();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(getContext(), "Fail to get data", Toast.LENGTH_SHORT).show();
                    }
                });

//        db.collection("news")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        List<News> newsList = new ArrayList<>();
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            newsList.add(new News(
//                                    document.get("name").toString(),
//                                    (document.get("description") == null) ? null : document.get("description").toString(),
//                                    document.get("image").toString()
//                            ));
//                        }
//                        newsAdapter.setNewsArrayLists(newsList);
//                        rvNews.setAdapter(newsAdapter);
//                        rvNews.setLayoutManager(new GridLayoutManager(getContext(), 1));
//                    } else {
//                        Log.d("ERROR", "Error getting documents", task.getException());
//                    }
//                });

//        newsArrayList.add(new News(
//                "Punya Mobil Listrik, Jangan Salah Pilih Ban Karena Bisa Boros Tenaga",
//                "Mengendarai mobil listrik atau hybrid memiliki banyak keuntungan. Selain hemat tenaga, mobil tersebut juga ramah lingkungan. Untuk perawatannya, mobil listrik atau hybrid memang cukup berbeda dibandingkan mobil bermesin konvensional. Bahkan, tak banyak yang paham bahwa dalam penggantian ban pun tidak bisa dilakukan sembarangan",
//                "22/12/2021"
//        ));
//        newsArrayList.add(new News(
//                "Sirkuit Mandalika Akan Jadi Tuan Rumah GT World Challenge Asia 2022",
//                "Mulai musim depan, Pertamina Mandalika International Street Circuit, Lombok, akan menjadi tuan rumah dari banyak kejuaraan balap bertaraf internasional. Selain World Superbike (WorldSBK) dan MotoGP, Sirkuit Mandalika belum lama ini dikabarkan masuk kalender GT World Challenge Asia 2022.",
//                "22/12/2021"
//        ));
//        newsArrayList.add(new News(
//                "Mobil Besar Namanya",
//                "Mobil banyak digunakan di jalanan besar dan ramai penduduk",
//                "10/11/2021"
//        ));
//        newsArrayList.add(new News(
//                "Motor Cepat Sekali",
//                "Motor banyak digunakan di daerah perkampungan untuk menjangkau daerah yang sulit",
//                "11/11/2021"
//        ));
    }
}
