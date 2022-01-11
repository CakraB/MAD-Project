package com.cakrab.project_mobile_vcare.Admin.Garage;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cakrab.project_mobile_vcare.Adapter.GarageAdapter;
import com.cakrab.project_mobile_vcare.Model.Garage;
import com.cakrab.project_mobile_vcare.R;

import java.util.ArrayList;

public class GarageActivity extends AppCompatActivity {

    RecyclerView rvGarage;
    ArrayList<Garage> garageArrayList;
    GarageAdapter garageAdapter;
    Button buttonAddGarage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);

        buttonAddGarage = findViewById(R.id.button_add_garage);
//        rvGarage = findViewById(R.id.rvGarage);
//        garageArrayList = new ArrayList<>();
//        garageAdapter = new GarageAdapter(garageArrayList, getApplicationContext());
//        rvGarage.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
//        rvGarage.setAdapter(garageAdapter);
//
//        garageArrayList.add(new Garage(
//                "Suzuki",
//                "20 Cabang"
//        ));
//        garageArrayList.add(new Garage(
//                "Honda",
//                "15 Cabang"
//        ));
//        garageArrayList.add(new Garage(
//                "Kawasaki",
//                "23 Cabang"
//        ));
//        garageArrayList.add(new Garage(
//                "Bengkel Abadi",
//                "20 Cabang"
//        ));
//        garageArrayList.add(new Garage(
//                "Toyota",
//                "54 Cabang"
//        ));
//        garageArrayList.add(new Garage(
//                "Bengkel Indah",
//                "2 Cabang"
//        ));
//        garageArrayList.add(new Garage(
//                "Lexus",
//                "3 Cabang"
//        ));
    }
}