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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<News> newsArrayLists;
    private Context context;

    public NewsAdapter(ArrayList<News> articles, Context context) {
        this.newsArrayLists = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_content, parent, false);
        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        News news = newsArrayLists.get(position);
        holder.textName.setText(news.getArticleName());
        holder.textDesc.setText(news.getArticleDesc());
        holder.textDate.setText(news.getArticleDate());
        holder.imageView.setImageResource(R.drawable.ic_launcher_background);

        // Click Detail Page
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailNewsActivity.class);
                i.putExtra("NAME", news.getArticleName());
                i.putExtra("DESC", news.getArticleDesc());
                i.putExtra("DATE", news.getArticleDate());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsArrayLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textName, textDesc, textDate;
        ImageView imageView;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_content_name);
            textDesc = itemView.findViewById(R.id.text_content_desc);
            textDate = itemView.findViewById(R.id.text_content_date);
            imageView = itemView.findViewById(R.id.image_content);
        }
    }
}
