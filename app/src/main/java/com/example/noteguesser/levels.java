package com.example.noteguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class levels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        getSupportActionBar().hide();

        configureBackButton();
        configureLevelOneButton();
        configureLevelTwoButton();
    }

    private void configureLevelOneButton(){
        Button levelOneButton = (Button) findViewById(R.id.levelOne);
        levelOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(levels.this, levelOne.class));
            }
        });
    }

    private void configureLevelTwoButton(){
        Button levelOneButton = (Button) findViewById(R.id.levelTwo);
        levelOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(levels.this, levelTwo.class));
            }
        });
    }

    private void configureBackButton(){
        Button backButton = (Button) findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}