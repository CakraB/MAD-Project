package com.cakrab.project_mobile_vcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    EditText editName, editEmail, editPassword;
    Button buttonSave;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editPassword = findViewById(R.id.edit_password);
        buttonSave = findViewById(R.id.button_save);

        Intent getData = getIntent();
        String getEmail = getData.getStringExtra("EMAIL");

        editEmail.setText(getEmail);

        buttonSave.setOnClickListener(view -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
    }
}