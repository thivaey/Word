package com.example.word.handleInvitation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.word.R;
import com.example.word.data.DataUtils;
import com.example.word.data.model.Challenge;
import com.example.word.ui.newchallenge.NewChallengeSentActivity;

public class CounterChallenge extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_counter_challenge);
    int id = getIntent().getIntExtra("ID", 0);
    Challenge invitation = DataUtils.getChallenge(id);
    TextView challenger = (TextView) findViewById(R.id.counter_challenger);
    TextView description = (TextView) findViewById(R.id.counter_description);
    if (invitation.getStatus() == Challenge.SEND) {
      challenger.setText("@" + invitation.getChallenger() + " Challenged you:");
      description.setText(invitation.getDescription());
    } else {
      challenger.setText("@" + invitation.getChallenged() + "'s Counter Challenge:");
      description.setText(invitation.getDescription());
    }

    ((TextView)findViewById(R.id.reaction_counter_challenge)).setOnClickListener(
      v -> {
        Intent intent = new Intent(CounterChallenge.this, NewChallengeSentActivity.class);
        startActivity(intent);
      }
    );


  }
}