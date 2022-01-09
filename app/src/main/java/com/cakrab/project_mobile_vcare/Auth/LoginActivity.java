package com.cakrab.project_mobile_vcare.Auth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cakrab.project_mobile_vcare.Admin.AdminActivity;
import com.cakrab.project_mobile_vcare.Database.UserHelper;
import com.cakrab.project_mobile_vcare.MainActivity;
import com.cakrab.project_mobile_vcare.R;

public class LoginActivity extends AppCompatActivity {

    EditText editEmail;
    EditText editPassword;
    Button buttonLogin;
    CheckBox checkRemember;
    TextView textRegisterHere;
    UserHelper dbUser;
    boolean isRemember = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Initialize Variable
        editEmail = findViewById(R.id.edit_email);
        editPassword = findViewById(R.id.edit_password);
        buttonLogin = findViewById(R.id.button_login);
        checkRemember = findViewById(R.id.check_remember);
        textRegisterHere = findViewById(R.id.text_register_here);
        dbUser = new UserHelper(getApplicationContext());

        SharedPreferences sharedPreferences = getSharedPreferences("REMEMBER", MODE_PRIVATE);
        isRemember = sharedPreferences.getBoolean("CHECKBOX", false);

        if (isRemember) {
            Intent login = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(login);
            finish();
        }

        // Button OnClick
        buttonLogin.setOnClickListener(view -> {
            // Get Input Value
            String getEmail = editEmail.getText().toString();
            String getPassword = editPassword.getText().toString();
            boolean rememberMe = checkRemember.isChecked();
            // Validate Email
            try {
                // Input Email is Empty
                if (getEmail.trim().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Email must be filled",Toast.LENGTH_SHORT).show();
                    return;
                }
               // Input Email is Format
                else if (!getEmail.contains("@") || !getEmail.endsWith(".com")) {
                    Toast.makeText(LoginActivity.this, "Email is invalid format", Toast.LENGTH_SHORT).show();
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
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(LoginActivity.this, "Error Found!, Please Try Again",Toast.LENGTH_SHORT).show();
            }
            // Check user credential
            if (dbUser.readUser(getEmail, getPassword)) {
                // Validate Remember Me Checkbox
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("EMAIL", getEmail);
                editor.putString("PASSWORD", getPassword);
                editor.putBoolean("CHECKBOX", rememberMe);
                editor.apply();

                if (rememberMe) {
                    Toast.makeText(LoginActivity.this, "Credential is saved", Toast.LENGTH_SHORT).show();
                }

                if (getEmail.contains("admin")) {
                    Intent admin = new Intent(LoginActivity.this, AdminActivity.class);
                    startActivity(admin);
                    finish();
                } else {
                    Intent login = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(login);
                    finish();
                }
            } else {
                Toast.makeText(LoginActivity.this, "User is not Exist", Toast.LENGTH_SHORT).show();
            }
            // Reset All Data on Input Fields
            editEmail.setText("");
            editPassword.setText("");
        });
        // Button Move to Register Page Action
        textRegisterHere.setOnClickListener(view -> {
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(i);
        });
    }
}