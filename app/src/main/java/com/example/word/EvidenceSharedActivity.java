package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class EvidenceSharedActivity extends AppCompatActivity {
    Button returnToMainButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evidence_shared);
        returnToMainButton = (Button) findViewById(R.id.evidenceSharedButton);
        returnToMainButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        });
    }
}