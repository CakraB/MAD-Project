package com.cakrab.project_mobile_vcare.Admin.Garage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cakrab.project_mobile_vcare.Adapter.GarageAdapter;
import com.cakrab.project_mobile_vcare.Model.Garage;
import com.cakrab.project_mobile_vcare.R;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class GarageActivity extends AppCompatActivity {

    RecyclerView garageRV;
    ArrayList<Garage> garageList;
    GarageAdapter garageAdapter;
    Button buttonAddGarage;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);

        buttonAddGarage = findViewById(R.id.button_add_garage);
        garageRV = findViewById(R.id.garageRV);
        db = FirebaseFirestore.getInstance();

        garageList = new ArrayList<>();
        garageAdapter = new GarageAdapter(garageList, GarageActivity.this);
        garageRV.setLayoutManager(new GridLayoutManager(GarageActivity.this, 2));
        garageRV.setAdapter(garageAdapter);

        // Retrieve Data from Firestore
        db.collection("garage")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot documentSnapshot : list) {
                            Garage garage = documentSnapshot.toObject(Garage.class);
                            if (garage != null) {
                                garage.setId(documentSnapshot.getId());
                            }
                            garageList.add(garage);
                        }
                        garageAdapter.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Fail to get data", Toast.LENGTH_SHORT).show());

        buttonAddGarage.setOnClickListener(view -> {
            Intent i = new Intent(GarageActivity.this, CreateGarageActivity.class);
            startActivity(i);
        });
    }
}