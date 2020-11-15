package com.example.word.handleInvitation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.word.R;
import com.example.word.data.DataUtils;
import com.example.word.data.model.Challenge;

public class ReactionActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_reaction);
    int id = getIntent().getIntExtra("ID", 0);
    Challenge invitation = DataUtils.getChallenge(id);
    
  }
}