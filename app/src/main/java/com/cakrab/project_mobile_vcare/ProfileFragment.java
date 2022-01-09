package com.cakrab.project_mobile_vcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cakrab.project_mobile_vcare.Auth.LoginActivity;

import org.jetbrains.annotations.NotNull;

public class ProfileFragment extends Fragment {

    TextView textProfileName, textProfileEmail;
    Button btnEditProfile, btnLogout;
    SharedPreferences sharedPreferences;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textProfileName = view.findViewById(R.id.text_profile_name);
        textProfileEmail = view.findViewById(R.id.text_profile_email);
        btnEditProfile = view.findViewById(R.id.btnEditProfile);
        btnLogout = view.findViewById(R.id.btnLogout);

        sharedPreferences = this.getActivity().getSharedPreferences("REMEMBER", Context.MODE_PRIVATE);
        String getData = sharedPreferences.getString("EMAIL", "");
        textProfileName.setText(getData);
        textProfileEmail.setText(getData);

        btnEditProfile.setOnClickListener(viewProfile -> {
            Intent intent = new Intent(getContext(), EditProfileActivity.class);
            startActivity(intent);
        });

        btnLogout.setOnClickListener(viewLogout -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();

            Intent logout = new Intent(getContext(), LoginActivity.class);
            startActivity(logout);
        });
    }
}
