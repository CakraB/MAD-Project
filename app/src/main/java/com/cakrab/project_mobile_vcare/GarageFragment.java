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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GarageFragment extends Fragment {

    RecyclerView rvGarages;
    ArrayList<garage> garageArrayList;
    GarageAdapter garageAdapter;

    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_garage, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvGarages = view.findViewById(R.id.rvGarage);
        garageArrayList = new ArrayList<>();
        garageAdapter = new GarageAdapter(garageArrayList, getContext());
        rvGarages.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvGarages.setAdapter(garageAdapter);

        garageArrayList.add(new garage(
                "Suzuki",
                "20 Cabang"
        ));
        garageArrayList.add(new garage(
                "Honda",
                "15 Cabang"
        ));
        garageArrayList.add(new garage(
                "Kawasaki",
                "23 Cabang"
        ));
        garageArrayList.add(new garage(
                "Bengkel Abadi",
                "20 Cabang"
        ));
        garageArrayList.add(new garage(
                "Toyota",
                "54 Cabang"
        ));
        garageArrayList.add(new garage(
                "Bengkel Indah",
                "2 Cabang"
        ));
        garageArrayList.add(new garage(
                "Lexus",
                "3 Cabang"
        ));
    }

}

