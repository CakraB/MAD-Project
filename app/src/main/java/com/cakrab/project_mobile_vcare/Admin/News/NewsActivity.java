package com.cakrab.project_mobile_vcare.Admin.News;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cakrab.project_mobile_vcare.Adapter.NewsAdapter;
import com.cakrab.project_mobile_vcare.Model.News;
import com.cakrab.project_mobile_vcare.R;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    RecyclerView rvNews;
    ArrayList<News> newsArrayList;
    NewsAdapter newsAdapter;
    Button buttonAddNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        buttonAddNews = findViewById(R.id.button_add_news);
        rvNews = findViewById(R.id.rvNews);
        newsArrayList = new ArrayList<>();
        newsAdapter = new NewsAdapter(newsArrayList, getApplicationContext());
        rvNews.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        rvNews.setAdapter(newsAdapter);

        newsArrayList.add(new News(
                "Punya Mobil Listrik, Jangan Salah Pilih Ban Karena Bisa Boros Tenaga",
                "Mengendarai mobil listrik atau hybrid memiliki banyak keuntungan. Selain hemat tenaga, mobil tersebut juga ramah lingkungan. Untuk perawatannya, mobil listrik atau hybrid memang cukup berbeda dibandingkan mobil bermesin konvensional. Bahkan, tak banyak yang paham bahwa dalam penggantian ban pun tidak bisa dilakukan sembarangan",
                "22/12/2021"
        ));
        newsArrayList.add(new News(
                "Sirkuit Mandalika Akan Jadi Tuan Rumah GT World Challenge Asia 2022",
                "Mulai musim depan, Pertamina Mandalika International Street Circuit, Lombok, akan menjadi tuan rumah dari banyak kejuaraan balap bertaraf internasional. Selain World Superbike (WorldSBK) dan MotoGP, Sirkuit Mandalika belum lama ini dikabarkan masuk kalender GT World Challenge Asia 2022.",
                "22/12/2021"
        ));
        newsArrayList.add(new News(
                "Mobil Besar Namanya",
                "Mobil banyak digunakan di jalanan besar dan ramai penduduk",
                "10/11/2021"
        ));
        newsArrayList.add(new News(
                "Motor Cepat Sekali",
                "Motor banyak digunakan di daerah perkampungan untuk menjangkau daerah yang sulit",
                "11/11/2021"
        ));

        buttonAddNews.setOnClickListener(view -> {
            Intent i = new Intent(NewsActivity.this, CreateNewsActivity.class);
            startActivity(i);
        });
    }
}