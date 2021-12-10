package com.cakrab.project_mobile_vcare;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        holder.garageName.setText(garage.getGarageName());
        holder.garageCabang.setText(garage.getGarageCabang());
        holder.garageImage.setImageResource(R.drawable.ic_launcher_background);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailGarageActivity.class);
                i.putExtra("NAME", garage.getGarageName());
                i.putExtra("CABANG", garage.getGarageCabang());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return garageArrayList.size();
    }

    public static class GarageViewHolder extends RecyclerView.ViewHolder {

        TextView garageName, garageCabang;
        ImageView garageImage;

        public GarageViewHolder(@NonNull View itemView) {
            super(itemView);
            garageName = itemView.findViewById(R.id.text_garage_name);
            garageCabang = itemView.findViewById(R.id.text_garage_cabang);
            garageImage = itemView.findViewById(R.id.image_garage);

        }
    }
}
