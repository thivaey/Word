package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LosingResolutionActivity extends AppCompatActivity {

    Button mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainActivity = (Button)(findViewById(R.id.losing_resolution_main_menu_button));
        setContentView(R.layout.activity_losing_resolution);
    }
}