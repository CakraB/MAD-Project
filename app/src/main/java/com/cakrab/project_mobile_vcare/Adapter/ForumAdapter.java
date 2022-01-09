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

import com.cakrab.project_mobile_vcare.DetailForumActivity;
import com.cakrab.project_mobile_vcare.Model.Forum;
import com.cakrab.project_mobile_vcare.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ViewHolder> {

    private ArrayList<Forum> forumArrayLists;
    private Context context;

    public ForumAdapter(ArrayList<Forum> forum, Context context) {
        this.forumArrayLists = forum;
        this.context = context;
    }

    @NonNull
    @Override
    public ForumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_forum, parent, false);
        return new ForumAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForumAdapter.ViewHolder holder, int position) {
        Forum forum = forumArrayLists.get(position);
        holder.textName.setText(forum.getForumName());
//        holder.textDesc.setText(forum.getForumDesc());
        holder.textDate.setText(forum.getForumDate());
        holder.imageView.setImageResource(R.drawable.ic_launcher_background);

        // Click Detail Page
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailForumActivity.class);
                i.putExtra("NAME", forum.getForumName());
                i.putExtra("DESC", forum.getForumDesc());
                i.putExtra("DATE", forum.getForumDate());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return forumArrayLists.size();
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
