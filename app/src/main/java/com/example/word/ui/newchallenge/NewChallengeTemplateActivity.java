package com.example.word.ui.newchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.word.R;

public class NewChallengeTemplateActivity extends AppCompatActivity implements View.OnClickListener {

    String friendName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_challenge_template);

        Intent parentIntent = getIntent();
        String username = parentIntent.getStringExtra("username");
        friendName = parentIntent.getStringExtra("friendName");

        TextView textView = (TextView) findViewById(R.id.new_challenge_template_header);
        textView.setText("Challenge " + friendName);

        (findViewById(R.id.new_template_coffee_push_ups_ll)).setOnClickListener(this);
        (findViewById(R.id.new_template_books_lunch_ll)).setOnClickListener(this);
        (findViewById(R.id.new_template_sales_drinks_ll)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(NewChallengeTemplateActivity.this, NewChallengeDescriptionActivity.class);
        int id = view.getId();
        switch (id){
            case R.id.new_template_coffee_push_ups_ll:
                intent.putExtra("description", "Do more pushups then me");
                intent.putExtra("winCondition", "Whoever can do more push ups in 1 min without stopping wins");
                intent.putExtra("reward", "Loser has to buy coffee for the winner");
                break;

            case R.id.new_template_books_lunch_ll:
                intent.putExtra("description", "Read 2 books in one month");
                intent.putExtra("winCondition", "If you can read 2 books in one month, you win, or else I win");
                intent.putExtra("reward", "Loser has to buy lunch for the winner");
                break;

            case R.id.new_template_sales_drinks_ll:
                intent.putExtra("description", "Get more sales than em this quarter");
                intent.putExtra("winCondition", "Whoever performs better this quarter wins");
                intent.putExtra("reward", "Loser has to buy drinks for the winner");
                break;
            default:
                intent.putExtra("description", "");
                intent.putExtra("winCondition", "");
                intent.putExtra("reward", "");
                break;
        }
        intent.putExtra("friendName", friendName);
        startActivity(intent);
    }
}