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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GarageAdapter extends RecyclerView.Adapter<GarageAdapter.GarageViewHolder> {

    private final ArrayList<Garage> garageList;
    private final Context context;

    public GarageAdapter(ArrayList<Garage> garage, Context context) {
        this.garageList = garage;
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
        Garage garage = garageList.get(position);
        holder.garageName.setText(garage.getGarageName());
        holder.garageDesc.setText(garage.getGarageDesc());
        // Convert Image Link To Image with Picasso Library
        if (garage.getGarageImage() != null) {
            Picasso.get().load(garage.getGarageImage()).into(holder.garageImage);
        } else {
            holder.garageImage.setImageResource(R.drawable.ic_launcher_background);
        }

        holder.itemView.setOnClickListener(view -> {
            Intent i = new Intent(context, DetailGarageActivity.class);
            i.putExtra("ID", garage.getId());
            i.putExtra("NAME", garage.getGarageName());
            i.putExtra("DESC", garage.getGarageDesc());
            i.putExtra("IMAGE", garage.getGarageImage());
            context.startActivity(i);
        });

    }

    @Override
    public int getItemCount() {
        return garageList.size();
    }

    public static class GarageViewHolder extends RecyclerView.ViewHolder {

        TextView garageName, garageDesc;
        ImageView garageImage;

        public GarageViewHolder(@NonNull View itemView) {
            super(itemView);
            garageName = itemView.findViewById(R.id.text_garage_name);
            garageDesc = itemView.findViewById(R.id.text_garage_desc);
            garageImage = itemView.findViewById(R.id.image_garage);
        }
    }
}
