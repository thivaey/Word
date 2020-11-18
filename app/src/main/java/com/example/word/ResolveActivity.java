package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResolveActivity extends AppCompatActivity {

    Button winButton;
    Button lostButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resolve);

        winButton = (Button)(findViewById(R.id.resolve_won_button));
        lostButton = (Button)(findViewById(R.id.resolve_lost_button));
        winButton.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ResolveActivity.this, SettlementActivity.class);
                    startActivity(intent);
                }
            }
        );

        lostButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(ResolveActivity.this, SettlementActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}