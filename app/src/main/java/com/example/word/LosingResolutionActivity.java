package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LosingResolutionActivity extends AppCompatActivity {

    Button main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_losing_resolution);
        main = (Button)(findViewById(R.id.losing_resolution_main_menu_button));

        main.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(LosingResolutionActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}