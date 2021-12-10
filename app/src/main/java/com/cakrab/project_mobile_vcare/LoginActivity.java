package com.cakrab.project_mobile_vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cakrab.project_mobile_vcare.Database.UserHelper;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText editEmail;
    EditText editPassword;
    Button buttonLogin;
    TextView textRegisterHere;
    UserHelper dbUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Initialize Variable
        editEmail = findViewById(R.id.edit_email);
        editPassword = findViewById(R.id.edit_password);
        buttonLogin = findViewById(R.id.button_login);
        textRegisterHere = findViewById(R.id.text_register_here);
        dbUser = new UserHelper(getApplicationContext());
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
//                    // Input Email is not Registered
//                    else if (!userList.contains(getEmail)) {
//                        Toast.makeText(LoginActivity.this, "Your Email is not Registered",Toast.LENGTH_SHORT).show();
//                        return;
//                    }
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
//                    // Input Email is not Registered
//                    else if (!userList.contains(getPassword)) {
//                        Toast.makeText(LoginActivity.this, "Your Password is Incorrect",Toast.LENGTH_SHORT).show();
//                        return;
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this, "Error Found!, Please Try Again",Toast.LENGTH_SHORT).show();
                }
                // Check user credential
                if (dbUser.readUser(getEmail, getPassword)) {
                    Intent login = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(login);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "User is not Exist", Toast.LENGTH_SHORT).show();
                }
                // Validate Success and Redirect to Home
//                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
//                startActivity(i);
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