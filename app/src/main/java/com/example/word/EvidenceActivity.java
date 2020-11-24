package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class EvidenceActivity extends AppCompatActivity {
    Button submitEvidenceButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evidence);

        submitEvidenceButton = (Button) findViewById(R.id.evidence_submitEvidence_button);
        submitEvidenceButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), EvidenceSharedActivity.class);
            startActivity(intent);

        });

    }
}