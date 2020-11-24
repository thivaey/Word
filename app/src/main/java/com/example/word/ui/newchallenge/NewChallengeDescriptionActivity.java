package com.example.word.ui.newchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.word.MainActivity;
import com.example.word.R;

public class NewChallengeDescriptionActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_challenge_description);

        Intent parentIntent = getIntent();
        String username = parentIntent.getStringExtra("username");
        String friendName = parentIntent.getStringExtra("friendName");

        TextView textView = (TextView) findViewById(R.id.new_challenge_description_header);
        textView.setText("Challenge " + friendName);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
          NewChallengeDescriptionActivity.this, NewChallengeDescriptionActivity.this, 2020, 11, 23
        );

        dateButton = (Button) findViewById(R.id.new_challenge_description_set_date_button);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        EditText description = (EditText) findViewById(R.id.new_ch_desc_description_edit);
        EditText winCondition = (EditText) findViewById(R.id.new_ch_desc_win_condition_edit);
        EditText reward = (EditText) findViewById(R.id.new_ch_desc_reward_edit);

        String descriptionPreText = parentIntent.getStringExtra("description");
        String winConditionPreText = parentIntent.getStringExtra("winCondition");
        String rewardPreText = parentIntent.getStringExtra("reward");

        if (!descriptionPreText.equals(""))
            description.setText(descriptionPreText);
        if (!winConditionPreText.equals(""))
            winCondition.setText(winConditionPreText);
        if (!rewardPreText.equals(""))
            reward.setText(rewardPreText);

        Button nextButton = (Button) findViewById(R.id.new_ch_description_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewChallengeDescriptionActivity.this, NewChallengeReviewActivity.class);
                intent.putExtra("description", description.getText().toString());
                intent.putExtra("winCondition", winCondition.getText().toString());
                intent.putExtra("reward", reward.getText().toString());
                intent.putExtra("endDate", dateButton.getText().toString());

                intent.putExtra("username", username);
                intent.putExtra("friendName", friendName);

                startActivity(intent);
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        dateButton.setText(String.valueOf(i1+1) + "/" + String.valueOf(i2) + "/" + String.valueOf(i));
    }
}