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

public class ForumFragment extends Fragment {

    RecyclerView rvForum;
    ArrayList<Forum> forumArrayList;
    ForumAdapter forumAdapter;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_forum, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvForum = view.findViewById(R.id.rvForum);
        forumArrayList = new ArrayList<Forum>();
        forumAdapter = new ForumAdapter(forumArrayList, getContext());
        rvForum.setLayoutManager(new GridLayoutManager(getContext(), 1));
        rvForum.setAdapter(forumAdapter);

        forumArrayList.add(new Forum(
                "Mobil",
                "Mobil bla bla bla",
                "10/11/2021"
        ));
        forumArrayList.add(new Forum(
                "Motor",
                "Motor bla bla bla",
                "10/11/2021"
        ));
    }
}
