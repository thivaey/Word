package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.app.assist.AssistStructure;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettlementActivity extends AppCompatActivity {

    Button agreeButton;
    Button disagreeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settlement);

        agreeButton = (Button)(findViewById(R.id.settlement_agree_button));
        disagreeButton = (Button)(findViewById(R.id.settlement_disagree_button));

        agreeButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(SettlementActivity.this, LosingActivity.class);
                        startActivity(intent);
                    }
                }
        );

        disagreeButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(SettlementActivity.this, WinningActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}