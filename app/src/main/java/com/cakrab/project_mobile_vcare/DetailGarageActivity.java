package com.cakrab.project_mobile_vcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailGarageActivity extends AppCompatActivity {

    TextView garageName, garageCabang;
    ImageView imageGarage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        garageName = findViewById(R.id.text_garage_name);
        garageCabang = findViewById(R.id.text_garage_cabang);
        imageGarage = findViewById(R.id.image_garage);

        Intent getGarage = getIntent();
        String getGarageName = getGarage.getStringExtra("NAME");
        String getGarageCabang = getGarage.getStringExtra("CABANG");

        garageName.setText(getGarageName);
        garageCabang.setText(getGarageCabang);
    }
}
