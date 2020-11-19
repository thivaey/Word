package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettlementWinActivity extends AppCompatActivity {

    Button agreeButton;
    Button disagreeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settlement_win);
        agreeButton = (Button)(findViewById(R.id.settlement_win_agree_button));
        disagreeButton = (Button)(findViewById(R.id.settlement_win_disagree_button));

        agreeButton.setOnClickListener(
                v->{
                    startActivity(new Intent(SettlementWinActivity.this, WinningActivity.class));
                }
        );

        disagreeButton.setOnClickListener(
                v-> {
                    startActivity(new Intent(SettlementWinActivity.this, DisagreementOccuredActivity.class));
                }
        );
    }
}