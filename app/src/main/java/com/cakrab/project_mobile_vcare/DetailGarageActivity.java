package com.cakrab.project_mobile_vcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailGarageActivity extends AppCompatActivity {

    TextView garageName, garageBranch;
    ImageView imageGarage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        garageName = findViewById(R.id.text_garage_name);
        garageBranch = findViewById(R.id.text_garage_branch);
        imageGarage = findViewById(R.id.image_garage);

        Intent getGarage = getIntent();
        String getGarageName = getGarage.getStringExtra("NAME");
        String getGarageBranch = getGarage.getStringExtra("BRANCH");

        garageName.setText(getGarageName);
        garageBranch.setText(getGarageBranch);
    }
}
