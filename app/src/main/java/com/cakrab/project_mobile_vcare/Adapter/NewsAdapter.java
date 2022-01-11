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

import com.cakrab.project_mobile_vcare.DetailNewsActivity;
import com.cakrab.project_mobile_vcare.Model.News;
import com.cakrab.project_mobile_vcare.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<News> newsList;
    private Context context;

    public NewsAdapter(Context context, ArrayList<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    // Cara Aslab
//    private List<News> newsList;
//    private Context context;
//
//    public NewsAdapter(Context context) {
//        this.context = context;
//    }
//
//    public void setNewsArrayLists(List<News> newsList) {
//        this.newsList = newsList;
//    }
//
//    public List<News> getNewsList() {
//        return newsList;
//    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.textName.setText(news.getNewsName());
        holder.textDesc.setText(news.getNewsDesc());
        // Convert Image Link To Image with Picasso Libraru
        if (news.getNewsImage() != null) {
            Picasso.get().load(news.getNewsImage()).into(holder.imageView);
        } else {
            holder.imageView.setImageResource(R.drawable.ic_launcher_background);
        }

        // Click Detail Page
        holder.itemView.setOnClickListener(view -> {
            Intent i = new Intent(context, DetailNewsActivity.class);
            i.putExtra("ID", news.getId());
            i.putExtra("NAME", news.getNewsName());
            i.putExtra("DESC", news.getNewsDesc());
            i.putExtra("IMAGE", news.getNewsImage());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textName, textDesc;
        ImageView imageView;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_content_name);
            textDesc = itemView.findViewById(R.id.text_content_desc);
            imageView = itemView.findViewById(R.id.image_content);
            // Test aja
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    News news = newsList.get(getAdapterPosition());
//                    Intent i = new Intent(context, DetailNewsActivity.class);
//                    i.putExtra("news", news);
//                    context.startActivity(i);
//                }
//            });
        }
    }
}
