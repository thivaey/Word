package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class DisagreementOccuredActivity extends AppCompatActivity {
    Button resolveWithFriendsButton;
    Button resolveWithLowerCredButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disagreement_occured);

        resolveWithFriendsButton = (Button) findViewById(R.id.disagreement_resolveWithFriends_button);
        resolveWithFriendsButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SelectFriendsActivity.class);
            startActivity(intent);

        });

        resolveWithLowerCredButton = (Button) findViewById(R.id.disagreement_resolveWithCredScore_button);
        resolveWithLowerCredButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ChallNotResolvedConfirmationActivity.class);
            startActivity(intent);
        });


    }
}