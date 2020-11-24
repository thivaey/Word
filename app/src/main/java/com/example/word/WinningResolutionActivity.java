package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.word.data.DataUtils;
import com.example.word.ui.newchallenge.NewChallengeActivity;
import com.example.word.ui.newchallenge.NewChallengeDescriptionActivity;

public class WinningResolutionActivity extends AppCompatActivity {

    Button main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_resolution);

        main = (Button)(findViewById(R.id.winning_resolution_main_activity_button));

        main.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getBaseContext(), MainActivity.class));
                    }
                }
        );

        ((Button)findViewById(R.id.winning_resolution_challenge_again_button)).setOnClickListener(
                v->{
                    Intent intent = new Intent(getBaseContext(), NewChallengeActivity.class);
                    intent.putExtra("username", DataUtils.getUser(DataUtils.getCurrUser()).getFullName());
                    intent.putExtra("friendName", "Ruisong");
                    startActivity(intent);
                }
        );
    }
}