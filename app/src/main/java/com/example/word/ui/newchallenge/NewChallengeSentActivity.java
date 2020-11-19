package com.example.word.ui.newchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.word.MainActivity;
import com.example.word.R;

public class NewChallengeSentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_challenge_sent);

        ((TextView) findViewById(R.id.new_ch_sent_text)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        navigateUpTo(new Intent(getBaseContext(), MainActivity.class));
                    }
                }
        );
    }
}