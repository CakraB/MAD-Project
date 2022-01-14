package com.cakrab.project_mobile_vcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    EditText editName, editEmail, editPassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editName = findViewById(R.id.inputFullname);
        editEmail = findViewById(R.id.inputEmail);
        editPassword = findViewById(R.id.inputPassword);

        Intent i = getIntent();
    }
}