package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WinningActivity extends AppCompatActivity {

    Button winResolveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);
        winResolveButton = (Button)(findViewById(R.id.winning_resolve_button));

        winResolveButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(WinningActivity.this, WinningResolutionActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}