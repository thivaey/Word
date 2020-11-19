package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ChallNotResolvedConfirmationActivity extends AppCompatActivity {
    Button continueNotResolvedButton;
    Button backNotResolvedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chall_not_resolved_confirmation);

        continueNotResolvedButton = (Button) findViewById(R.id.challNotResolvedContinue_button);
        continueNotResolvedButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        });

        backNotResolvedButton = (Button) findViewById(R.id.challNotResolvedBack_button);
        backNotResolvedButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });


    }
}