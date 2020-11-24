package com.example.word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class UploadEvidenceActivity extends AppCompatActivity {
    Button takePicButton;
    Button uploadDeviceButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_evidence);

        takePicButton = (Button) findViewById(R.id.takePicture_button);
        takePicButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), EvidenceActivity.class);
            startActivity(intent);

        });

        uploadDeviceButton = (Button) findViewById(R.id.uploadDevice_button);
        uploadDeviceButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), EvidenceActivity.class);
            startActivity(intent);
        });

    }
}