package com.cakrab.project_mobile_vcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cakrab.project_mobile_vcare.Adapter.GarageAdapter;
import com.cakrab.project_mobile_vcare.Model.Garage;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GarageFragment extends Fragment {

    RecyclerView rvGarage;
    ArrayList<Garage> garageArrayList;
    GarageAdapter garageAdapter;

    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_garage, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvGarage = view.findViewById(R.id.rvGarage);
        garageArrayList = new ArrayList<>();
        garageAdapter = new GarageAdapter(garageArrayList, getContext());
        rvGarage.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvGarage.setAdapter(garageAdapter);

        garageArrayList.add(new Garage(
                "Suzuki",
                "20 Cabang"
        ));
        garageArrayList.add(new Garage(
                "Honda",
                "15 Cabang"
        ));
        garageArrayList.add(new Garage(
                "Kawasaki",
                "23 Cabang"
        ));
        garageArrayList.add(new Garage(
                "Bengkel Abadi",
                "20 Cabang"
        ));
        garageArrayList.add(new Garage(
                "Toyota",
                "54 Cabang"
        ));
        garageArrayList.add(new Garage(
                "Bengkel Indah",
                "2 Cabang"
        ));
        garageArrayList.add(new Garage(
                "Lexus",
                "3 Cabang"
        ));
    }

}

