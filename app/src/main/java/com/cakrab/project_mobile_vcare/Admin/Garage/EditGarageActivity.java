package com.cakrab.project_mobile_vcare.Admin.Garage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cakrab.project_mobile_vcare.Model.Garage;
import com.cakrab.project_mobile_vcare.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

public class EditGarageActivity extends AppCompatActivity {

    EditText editGarageName, editGarageDesc, editGarageImage;
    Button buttonUpdateGarage, buttonDeleteGarage;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_garage);
        init();
        setAction();
    }

    public void init() {
        editGarageName = findViewById(R.id.edit_garage_name);
        editGarageDesc = findViewById(R.id.edit_garage_desc);
        editGarageImage = findViewById(R.id.edit_garage_image);
        buttonUpdateGarage = findViewById(R.id.button_update_garage);
        buttonDeleteGarage = findViewById(R.id.button_delete_garage);
        db = FirebaseFirestore.getInstance();
    }

    public void setAction() {
        Intent getGarage = getIntent();
        String getGarageId = getGarage.getStringExtra("ID");
        String getGarageName = getGarage.getStringExtra("NAME");
        String getGarageDesc = getGarage.getStringExtra("DESC");
        String getGarageImage = getGarage.getStringExtra("IMAGE");

        editGarageName.setText(getGarageName);
        editGarageDesc.setText(getGarageDesc);
        editGarageImage.setText(getGarageImage);

        buttonUpdateGarage.setOnClickListener(view -> {
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
                updateGarage(getGarageId, garageName, garageDesc, garageImage);
            }
        });

        buttonDeleteGarage.setOnClickListener(view -> {
            deleteGarage(getGarageId);
        });

    }

    private void updateGarage(String garageId, String garageName, String garageDesc, String garageImage) {
        Garage updateGarage = new Garage(garageName, garageDesc, garageImage);
        db.collection("garage").
                document(garageId).
                set(updateGarage).
                addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(EditGarageActivity.this, "Garage has been updated..", Toast.LENGTH_SHORT).show();
                        Intent back = new Intent(getApplicationContext(), GarageActivity.class);
                        startActivity(back);
                    }
                }).
                addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Toast.makeText(EditGarageActivity.this, "Fail to update the data..", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void deleteGarage(String garageId) {
        db.collection("garage").
                document(garageId).
                delete().
                addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(EditGarageActivity.this, "Garage has been deleted from Database.", Toast.LENGTH_SHORT).show();
                            Intent back = new Intent(getApplicationContext(), GarageActivity.class);
                            startActivity(back);
                        } else {
                            Toast.makeText(EditGarageActivity.this, "Fail to delete the garage. ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}