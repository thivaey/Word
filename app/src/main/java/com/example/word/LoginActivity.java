package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.word.data.DataUtils;

public class LoginActivity extends AppCompatActivity  {

    Button loginButton;
    Button signupButton;

    EditText usernameEditText;
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button)(findViewById(R.id.login_login_button));
        signupButton = (Button)(findViewById(R.id.login_signup_button));

        usernameEditText = (EditText) findViewById(R.id.login_username);
        passwordEditText = (EditText) findViewById(R.id.login_password);

        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println(usernameEditText.getText().toString());
                        Log.d("LOGIN_DEBUG", usernameEditText.getText().toString());
                        DataUtils.setCurrUser(usernameEditText.getText().toString().trim());
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("username", usernameEditText.getText().toString());
                        startActivity(intent);
                    }
                }
        );
    }

//    @Override
//    public void onClick(View view) {
//
//    }
}