package com.cakrab.project_mobile_vcare.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cakrab.project_mobile_vcare.DetailGarageActivity;
import com.cakrab.project_mobile_vcare.Model.Garage;
import com.cakrab.project_mobile_vcare.R;

import java.util.ArrayList;

public class GarageAdapter extends RecyclerView.Adapter<GarageAdapter.GarageViewHolder> {

    private final ArrayList <Garage> garageArrayList;
    private final Context context;

    public GarageAdapter(ArrayList<Garage> garage, Context context){
        this.garageArrayList = garage;
        this.context = context;
    }

    @NonNull
    @Override
    public GarageAdapter.GarageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_garage, parent, false);
        return new GarageAdapter.GarageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GarageViewHolder holder, int position) {
        Garage garage = garageArrayList.get(position);
        holder.garageName.setText(garage.getGarageName());
        holder.garageBranch.setText(garage.getGarageBranch());
        holder.garageImage.setImageResource(R.drawable.ic_launcher_background);

        holder.itemView.setOnClickListener(view -> {
            Intent i = new Intent(context, DetailGarageActivity.class);
            i.putExtra("NAME", garage.getGarageName());
            i.putExtra("BRANCH", garage.getGarageBranch());
            context.startActivity(i);
        });

    }

    @Override
    public int getItemCount() {
        return garageArrayList.size();
    }

    public static class GarageViewHolder extends RecyclerView.ViewHolder {

        TextView garageName, garageBranch;
        ImageView garageImage;

        public GarageViewHolder(@NonNull View itemView) {
            super(itemView);
            garageName = itemView.findViewById(R.id.text_garage_name);
            garageBranch = itemView.findViewById(R.id.text_garage_branch);
            garageImage = itemView.findViewById(R.id.image_garage);
        }
    }
}
