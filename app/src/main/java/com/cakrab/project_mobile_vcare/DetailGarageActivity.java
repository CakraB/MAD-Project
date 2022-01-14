package com.cakrab.project_mobile_vcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cakrab.project_mobile_vcare.Admin.Garage.EditGarageActivity;
import com.squareup.picasso.Picasso;

public class DetailGarageActivity extends AppCompatActivity {

    TextView garageName, garageDesc;
    Button buttonEdit;
    ImageView imageGarage;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_garage);

        garageName = findViewById(R.id.text_garage_name);
        garageDesc = findViewById(R.id.text_garage_desc);
        imageGarage = findViewById(R.id.image_garage);
        buttonEdit = findViewById(R.id.button_edit);

        Intent getGarage = getIntent();
        String getGarageId = getGarage.getStringExtra("ID");
        String getGarageName = getGarage.getStringExtra("NAME");
        String getGarageDesc = getGarage.getStringExtra("DESC");
        String getGarageImage = getGarage.getStringExtra("IMAGE");

        garageName.setText(getGarageName);
        garageDesc.setText(getGarageDesc);
        if (getGarageImage != null) {
            Picasso.get().load(getGarageImage).into(imageGarage);
        } else {
            Picasso.get().load(R.drawable.ic_launcher_background).into(imageGarage);
        }

        // SharedPreference
        sharedPreferences = this.getSharedPreferences("REMEMBER", Context.MODE_PRIVATE);
        String getData = sharedPreferences.getString("EMAIL", "");

        if (getData.equals("admin@gmail.com")) {
            buttonEdit.setVisibility(View.VISIBLE);

            buttonEdit.setOnClickListener(view -> {
                Intent i = new Intent(this, EditGarageActivity.class);
                i.putExtra("ID", getGarageId);
                i.putExtra("NAME", getGarageName);
                i.putExtra("DESC", getGarageDesc);
                i.putExtra("IMAGE", getGarageImage);
                startActivity(i);
            });
        } else {
            buttonEdit.setVisibility(View.INVISIBLE);
        }
    }
}
