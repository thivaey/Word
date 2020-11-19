package com.example.word.ui.newchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.word.R;

public class NewChallengeReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_challenge_review);


        Intent parentIntent = getIntent();
        String username = parentIntent.getStringExtra("username");
        String friendName = parentIntent.getStringExtra("friendName");

        TextView textView = (TextView) findViewById(R.id.new_challenge_review_header);
        textView.setText("Challenge " + friendName);

        ((TextView) findViewById(R.id.new_ch_review_description_text)).setText(
                parentIntent.getStringExtra("description")
        );

        ((TextView) findViewById(R.id.new_ch_review_win_conditon_text)).setText(
                parentIntent.getStringExtra("winCondition")
        );

        ((TextView) findViewById(R.id.new_ch_review_reward_text)).setText(
                parentIntent.getStringExtra("reward")
        );

        ((TextView) findViewById(R.id.new_ch_review_end_date)).setText(
                parentIntent.getStringExtra("endDate")
        );

        ((Button) findViewById(R.id.new_ch_review_send_button)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(NewChallengeReviewActivity.this, NewChallengeSentActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}