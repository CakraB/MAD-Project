package com.cakrab.project_mobile_vcare;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GarageAdapter extends RecyclerView.Adapter<GarageAdapter.GarageViewHolder> {

    private ArrayList <garage> garageArrayList;
    private Context context;

    public GarageAdapter(ArrayList<garage> garages, Context context){
        this.garageArrayList = garages;
        this.context = context;
    }

    @NonNull
    @Override
    public GarageAdapter.GarageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_content, parent, false);
        return new GarageAdapter.GarageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GarageViewHolder holder, int position) {
        garage garage = garageArrayList.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class GarageViewHolder extends RecyclerView.ViewHolder {
        public GarageViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
