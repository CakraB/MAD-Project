package com.cakrab.project_mobile_vcare.Admin.Garage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cakrab.project_mobile_vcare.Model.Garage;
import com.cakrab.project_mobile_vcare.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreateGarageActivity extends AppCompatActivity {

    EditText editGarageName, editGarageDesc, editGarageImage;
    Button buttonAddGarage;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_garage);
        init();
        setAction();
    }

    public void init() {
        editGarageName = findViewById(R.id.edit_garage_name);
        editGarageDesc = findViewById(R.id.edit_garage_desc);
        editGarageImage = findViewById(R.id.edit_garage_image);
        buttonAddGarage = findViewById(R.id.button_submit_garage);
        db = FirebaseFirestore.getInstance();
    }

    public void setAction() {
        buttonAddGarage.setOnClickListener(view -> {
            String garageName = editGarageName.getText().toString();
            String garageDesc = editGarageDesc.getText().toString();
            String garageImage = editGarageImage.getText().toString();

            if (TextUtils.isEmpty(garageName)) {
                editGarageName.setError("Please enter Garage Name");
            } else if (TextUtils.isEmpty(garageDesc)) {
                editGarageDesc.setError("Please enter Garage Description");
            } else if (TextUtils.isEmpty(garageImage)) {
                editGarageImage.setError("Please enter Garage URL Image");
            } else {
                addGarage(garageName, garageDesc, garageImage);
            }
        });
    }

    private void addGarage(String garageName, String garageDesc, String garageImage) {
        CollectionReference dbGarage = db.collection("garage");
        Garage garage = new Garage(garageName, garageDesc, garageImage);
        dbGarage.add(garage).addOnSuccessListener(documentReference -> {
            Toast.makeText(getApplicationContext(), "Your Garage has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
            Intent back = new Intent(getApplicationContext(), GarageActivity.class);
            startActivity(back);
        }).addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Fail to add garage \n" + e, Toast.LENGTH_SHORT).show());
    }
}