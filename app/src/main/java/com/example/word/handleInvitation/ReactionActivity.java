package com.example.word.handleInvitation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.word.MainActivity;
import com.example.word.R;
import com.example.word.data.DataUtils;
import com.example.word.data.model.Challenge;

import org.w3c.dom.Text;

public class ReactionActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_reaction);
    int id = getIntent().getIntExtra("ID", 0);
    Challenge invitation = DataUtils.getChallenge(id);

    TextView challenger = (TextView) findViewById(R.id.reaction_challenger);
    TextView description = (TextView) findViewById(R.id.reaction_description);
    TextView title1 = (TextView) findViewById(R.id.reaction_description_title);
    TextView title2 = (TextView) findViewById(R.id.reaction_penalty_title);
    TextView detail1 = (TextView) findViewById(R.id.reaction_description_details);
    TextView detail2 = (TextView) findViewById(R.id.reaction_penalty_details);
    TextView startDate = (TextView) findViewById(R.id.reaction_start_date);
    TextView endDate = (TextView) findViewById(R.id.reaction_end_date);

    if (invitation.getStatus() == Challenge.SEND) {
      challenger.setText("@" + invitation.getChallenger() + " Challenged you:");
      description.setText(invitation.getDescription());
      title1.setText("Description (By " + invitation.getChallenger() +")");
      title2.setText("Penalty (By " + invitation.getChallenger() +")");
      detail1.setText(invitation.getDescription());
      detail2.setText(invitation.getPenaltyByChallenger());
      startDate.setText("SENT ON: " + invitation.getStartDate());
      endDate.setText("ENDS AT: " + invitation.getEndDate());
    } else {
      challenger.setText("@" + invitation.getChallenged() + "'s Counter Challenge:");
      description.setText(invitation.getDescription());
      title1.setText("Description (By " + invitation.getChallenged() +")");
      title2.setText("Penalty (By " + invitation.getChallenged() +")");
      detail1.setText(invitation.getDescription());
      detail2.setText(invitation.getPenaltyByChallenged());
      startDate.setText("SENT ON: " + invitation.getStartDate());
      endDate.setText("ENDS AT: " + invitation.getEndDate());
    }

    ImageView counterChallenge = (ImageView) findViewById(R.id.reaction_counter_challenge);
    ImageView accept = (ImageView) findViewById(R.id.reaction_accept);
    ImageView decline = (ImageView) findViewById(R.id.reaction_decline);

    counterChallenge.setOnClickListener(view -> {
      Intent intent = new Intent(getApplicationContext(), CounterChallenge.class);
      intent.putExtra("ID", invitation.getId());
      startActivity(intent);
    });

    decline.setOnClickListener(view -> {
      new AlertDialog.Builder(this)
              .setTitle("Confirm Your Action")
              .setMessage("Are you sure you want to decline this challenge?")
              .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                  Toast.makeText(ReactionActivity.this, "Challenge Declined", Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                  startActivity(intent);
                }})
              .setNegativeButton(android.R.string.no, null).show();
    });

    accept.setOnClickListener(view -> {
      new AlertDialog.Builder(this)
              .setTitle("Confirm Your Action")
              .setMessage("Accept the challenge means you agree with the winning condition and penalty listed on the page")
              .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                  Toast.makeText(ReactionActivity.this, "Challenge Accepted", Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                  startActivity(intent);
                }})
              .setNegativeButton(android.R.string.no, null).show();
    });

  }
}