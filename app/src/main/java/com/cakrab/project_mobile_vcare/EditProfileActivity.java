package com.cakrab.project_mobile_vcare;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.cakrab.project_mobile_vcare.Database.UserHelper;

public class EditProfileActivity extends AppCompatActivity {

    EditText editName, editEmail, editPassword;
    Button buttonSave;
    UserHelper dbUser;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editPassword = findViewById(R.id.edit_password);
        buttonSave = findViewById(R.id.button_save);
        dbUser = new UserHelper(getApplicationContext());

        Intent getData = getIntent();
        String getEmail = getData.getStringExtra("EMAIL");
        Log.d("EMAIL", "Email User => " + getEmail);

        editEmail.setText(getEmail);

        buttonSave.setOnClickListener(view -> {
            Intent i = new Intent(EditProfileActivity.this, MainActivity.class);
            startActivity(i);
        });
    }

}