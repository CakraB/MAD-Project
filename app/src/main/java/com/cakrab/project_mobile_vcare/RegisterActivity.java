package com.cakrab.project_mobile_vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Initialize Variable
        EditText editName = findViewById(R.id.edit_name);
        EditText editEmail = findViewById(R.id.edit_email);
        EditText editPassword = findViewById(R.id.edit_password);
        EditText editPasswordCon = findViewById(R.id.edit_password_confirm);
        Button buttonRegister = findViewById(R.id.button_register);
        TextView textLoginHere = findViewById(R.id.text_login_here);
        // Button OnClick
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Input Value
                String getName = editName.getText().toString();
                String getEmail = editEmail.getText().toString();
                String getPassword = editPassword.getText().toString();
                String getPasswordCon = editPasswordCon.getText().toString();
                // Validate Name
                try {
                    // Input Name is Empty
                    if (getName.trim().isEmpty()) {
                        Toast.makeText(RegisterActivity.this, "Name must be filled",Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(RegisterActivity.this, "Error Found!, Please Try Again",Toast.LENGTH_SHORT).show();
                }
                // Validate Email
                try {
                    // Input Email is Empty
                    if (getEmail.trim().isEmpty()) {
                        Toast.makeText(RegisterActivity.this, "Email must be filled",Toast.LENGTH_SHORT).show();
                        return;
                    } else if (!getEmail.contains("@") || !getEmail.endsWith(".com")) {
                        Toast.makeText(RegisterActivity.this, "Email is invalid format", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(RegisterActivity.this, "Error Found!, Please Try Again",Toast.LENGTH_SHORT).show();
                }
                // Validate Password
                try {
                    // Input Email is Empty
                    if (getPassword.trim().isEmpty()) {
                        Toast.makeText(RegisterActivity.this, "Password must be filled",Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(RegisterActivity.this, "Error Found!, Please Try Again",Toast.LENGTH_SHORT).show();
                }
                // Validate Password Confirmation
                try {
                    // Input Email is Empty
                    if (getPasswordCon.trim().isEmpty()) {
                        Toast.makeText(RegisterActivity.this, "Confirmation must be filled",Toast.LENGTH_SHORT).show();
                        return;
                    } else if(!getPasswordCon.equals(getPassword)) {
                        Toast.makeText(RegisterActivity.this, "Confirmation must be same as password",Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(RegisterActivity.this, "Error Found!, Please Try Again",Toast.LENGTH_SHORT).show();
                }
                // Validate Success and Redirect to Login
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                i.putExtra("EMAIL", getEmail);
                i.putExtra("PASSWORD", getPassword);
                startActivity(i);
                // Reset All Data on Input Fields
                editName.setText("");
                editEmail.setText("");
                editPassword.setText("");
                editPasswordCon.setText("");
            }
        });

        // Button Move to Register Page Action
        textLoginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}