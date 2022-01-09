package com.cakrab.project_mobile_vcare;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    TextView textEmail;
    RecyclerView rvNews;
    ArrayList<News> newsArrayList;
    NewsAdapter newsAdapter;
    SharedPreferences sharedPreferences;
    boolean isRemember = false;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvNews = view.findViewById(R.id.rvNews);
        textEmail = view.findViewById(R.id.text_email);

        sharedPreferences = this.getActivity().getSharedPreferences("REMEMBER", Context.MODE_PRIVATE);
        isRemember = sharedPreferences.getBoolean("CHECKBOX",false);

        String getData = sharedPreferences.getString("EMAIL", "");
        textEmail.setText(getData);

        newsArrayList = new ArrayList<>();
        newsAdapter = new NewsAdapter(newsArrayList, getContext());
        rvNews.setLayoutManager(new GridLayoutManager(getContext(), 1));
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
    }
}
