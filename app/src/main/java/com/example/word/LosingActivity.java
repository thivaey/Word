package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LosingActivity extends AppCompatActivity {

    Button losingResolutionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losing);
        losingResolutionButton = (Button)(findViewById(R.id.losing_resolve_button));

        losingResolutionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(LosingActivity.this, LosingResolutionActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}