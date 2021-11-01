package com.cakrab.project_mobile_vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Initialize Variable
        EditText editEmail = findViewById(R.id.edit_email);
        EditText editPassword = findViewById(R.id.edit_password);
        Button buttonLogin = findViewById(R.id.button_login);
        TextView textRegisterHere = findViewById(R.id.text_register_here);
        // Save Temporary
        ArrayList<String> userList = new ArrayList<String>();
        // Hard Code Account
        userList.add("admin@admin.com");
        userList.add("admin123");
        // Get Data Register
        Intent getData = getIntent();
        String getEmailData = getData.getStringExtra("EMAIL");
        String getPasswordData = getData.getStringExtra("PASSWORD");
        // Save Data Register to Array
        userList.add(getEmailData);
        userList.add(getPasswordData);
        // Button OnClick
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Input Value
                String getEmail = editEmail.getText().toString();
                String getPassword = editPassword.getText().toString();
                // Validate Email
                try {
                    // Input Email is Empty
                    if (getEmail.trim().isEmpty()) {
                        Toast.makeText(LoginActivity.this, "Email must be filled",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // Input Email is not Registered
                    else if (!userList.contains(getEmail)) {
                        Toast.makeText(LoginActivity.this, "Your Email is not Registered",Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this, "Error Found!, Please Try Again",Toast.LENGTH_SHORT).show();
                }
                // Validate Password
                try {
                    // Input Email is Empty
                    if (getPassword.trim().isEmpty()) {
                        Toast.makeText(LoginActivity.this, "Password must be filled",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // Input Email is not Registered
                    else if (!userList.contains(getPassword)) {
                        Toast.makeText(LoginActivity.this, "Your Password is Incorrect",Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this, "Error Found!, Please Try Again",Toast.LENGTH_SHORT).show();
                }
                // Validate Success and Redirect to Home
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
                // Reset All Data on Input Fields
                editEmail.setText("");
                editPassword.setText("");
            }
        });
        // Button Move to Register Page Action
        textRegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}