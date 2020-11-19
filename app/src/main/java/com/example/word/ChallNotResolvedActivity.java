package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ChallNotResolvedActivity extends AppCompatActivity {
    Button goPublicButton;
    Button resolveWithLowerCredButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chall_not_resolved);

        goPublicButton = (Button) findViewById(R.id.disagreement_resolveWithFriends_button);
        goPublicButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), EvidenceSharedActivity.class);
            startActivity(intent);

        });

        resolveWithLowerCredButton = (Button) findViewById(R.id.disagreement_resolveWithCredScore_button);
        resolveWithLowerCredButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ChallNotResolvedConfirmationActivity.class);
            startActivity(intent);
        });

    }
}