package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SelectFriendsActivity extends AppCompatActivity {
    ListView selectFriendslistView;
    ArrayAdapter<String> adapter;
    Button  backButton;
    Button  nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_friends);

        selectFriendslistView = (ListView) findViewById(R.id.list);
        String[] friendArray = getResources().getStringArray(R.array.friends_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, friendArray);
        selectFriendslistView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        selectFriendslistView.setAdapter(adapter);
        backButton= (Button) findViewById(R.id.select_friends_back_button);
        backButton.setOnClickListener(view -> {
            Intent intent= new Intent(getApplicationContext(),DisagreementOccuredActivity.class);
            startActivity(intent);
        });

        nextButton= (Button) findViewById(R.id.select_friends_next_button);
        nextButton.setOnClickListener(view -> {
            Intent intent= new Intent(getApplicationContext(),UploadEvidenceActivity.class);
            startActivity(intent);
        });

    }
}