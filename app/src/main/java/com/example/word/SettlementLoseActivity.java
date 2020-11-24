package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettlementLoseActivity extends AppCompatActivity {

    Button agreeButton;
    Button disagreeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settlement);

        agreeButton = (Button)(findViewById(R.id.settlement_agree_button));
        disagreeButton = (Button)(findViewById(R.id.settlement_disagree_button));

        agreeButton.setOnClickListener(
                v->{
                        startActivity(new Intent(SettlementLoseActivity.this, LosingActivity.class));
                }
        );

        disagreeButton.setOnClickListener(
                v-> {
                    startActivity(new Intent(SettlementLoseActivity.this, DisagreementOccuredActivity.class));
                }
        );

    }
}