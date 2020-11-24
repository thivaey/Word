package com.example.word.ui.newchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.word.R;

public class NewChallengeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_challenge);

        Intent parentIntent = getIntent();
        String username = parentIntent.getStringExtra("username");
        String friendName = parentIntent.getStringExtra("friendName");

        Button templateButton = (Button) findViewById(R.id.new_challenge_choose_from_template_button);
        Button customButton = (Button) findViewById(R.id.new_challenge_custom_challenge_button);

        TextView textView = (TextView) findViewById(R.id.new_challenge_header);
        textView.setText("Challenge " + friendName);

        templateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(NewChallengeActivity.this, "This feature is not available yet", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(NewChallengeActivity.this, NewChallengeTemplateActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("friendName",friendName);
                startActivity(intent);
            }
        });

        customButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(NewChallengeActivity.this, NewChallengeDescriptionActivity.class);
                        intent.putExtra("username", username);
                        intent.putExtra("friendName",friendName);

                        intent.putExtra("description", "");
                        intent.putExtra("winCondition", "");
                        intent.putExtra("reward", "");

                        startActivity(intent);
                    }
                }
        );
    }
}