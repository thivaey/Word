package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WinningResolutionActivity extends AppCompatActivity {

    Button main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_resolution);

        main = (Button)(findViewById(R.id.winning_resolution_main_activity_button));

        main.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(WinningResolutionActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}