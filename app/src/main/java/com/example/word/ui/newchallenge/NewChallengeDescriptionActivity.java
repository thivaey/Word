package com.example.word.ui.newchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.word.R;

public class NewChallengeDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_challenge_description);

        Intent parentIntent = getIntent();
        String username = parentIntent.getStringExtra("username");
        String friendName = parentIntent.getStringExtra("friendName");

        TextView textView = (TextView) findViewById(R.id.new_challenge_description_header);
        textView.setText("Challenge " + friendName);

        Button setDate = (Button) findViewById(R.id.new_challenge_description_set_date_button);
        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate.setText("12/09/2020");
            }
        });

        Button nextButton = (Button) findViewById(R.id.new_ch_description_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText description = (EditText) findViewById(R.id.new_ch_desc_description_edit);
                EditText winCondition = (EditText) findViewById(R.id.new_ch_desc_win_condition_edit);
                EditText reward = (EditText) findViewById(R.id.new_ch_desc_reward_edit);

                Intent intent = new Intent(NewChallengeDescriptionActivity.this, NewChallengeReviewActivity.class);
                intent.putExtra("description", description.getText().toString());
                intent.putExtra("winCondition", winCondition.getText().toString());
                intent.putExtra("reward", reward.getText().toString());
                intent.putExtra("endDate", setDate.getText().toString());

                intent.putExtra("username", username);
                intent.putExtra("friendName", friendName);

                startActivity(intent);
            }
        });
    }
}