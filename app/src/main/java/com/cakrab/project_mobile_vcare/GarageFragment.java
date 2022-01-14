package com.cakrab.project_mobile_vcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cakrab.project_mobile_vcare.Adapter.GarageAdapter;
import com.cakrab.project_mobile_vcare.Model.Garage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GarageFragment extends Fragment {

    RecyclerView rvGarage;
    ArrayList<Garage> garageList;
    GarageAdapter garageAdapter;
    FirebaseFirestore db;

    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_garage, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvGarage = view.findViewById(R.id.rvGarage);
        db = FirebaseFirestore.getInstance();

        garageList = new ArrayList<>();
        garageAdapter = new GarageAdapter(garageList, getContext());
        rvGarage.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvGarage.setAdapter(garageAdapter);

        // Retrieve Data from Firestore
        db.collection("garage")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot documentSnapshot : list) {
                                Garage garage = documentSnapshot.toObject(Garage.class);
                                garage.setId(documentSnapshot.getId());
                                garageList.add(garage);
                            }
                            garageAdapter.notifyDataSetChanged();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(getContext(), "Fail to get data", Toast.LENGTH_SHORT).show();
                    }
                });

//        garageArrayList.add(new Garage(
//                "Suzuki",
//                "20 Cabang",
//                "Logo Suzuki"
//        ));
//        garageArrayList.add(new Garage(
//                "Honda",
//                "15 Cabang",
//                "Logo Honda"
//        ));
//        garageArrayList.add(new Garage(
//                "Kawasaki",
//                "23 Cabang",
//                "Logo Kawasaki"
//        ));
//        garageArrayList.add(new Garage(
//                "Bengkel Abadi",
//                "20 Cabang",
//                "Logo"
//        ));
//        garageArrayList.add(new Garage(
//                "Toyota",
//                "54 Cabang",
//                "Logo"
//        ));
//        garageArrayList.add(new Garage(
//                "Bengkel Indah",
//                "2 Cabang",
//                "Logo"
//        ));
//        garageArrayList.add(new Garage(
//                "Lexus",
//                "3 Cabang",
//                "Logo"
//        ));
    }

}

