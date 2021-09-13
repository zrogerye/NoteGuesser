package com.example.noteguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class levelOne extends AppCompatActivity {

    String answer;
    EditText answerInput;
    Button submitButton;
    String soundId;
    List<Integer> soundList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        getSupportActionBar().hide();

        configureSubmitButton();
        configureLevelsButton();
        configureSoundButton();


    }

    private void configureLevelsButton(){
        Button backLevelsOneButton = (Button) findViewById(R.id.backLevelsOne);
        backLevelsOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void configureSoundButton(){
        MediaPlayer soundStartOne = MediaPlayer.create(this, R.raw.c);

        //add all the notes to a list and then set the random to id

        //maybe try with map

        soundList = new ArrayList<Integer>();
        soundList.add(R.raw.a);
        soundList.add(R.raw.b);
        soundList.add(R.raw.bb);
        soundList.add(R.raw.c);
        soundList.add(R.raw.cs);
        soundList.add(R.raw.d);
        soundList.add(R.raw.e);
        soundList.add(R.raw.eb);
        soundList.add(R.raw.f);
        soundList.add(R.raw.fb);
        soundList.add(R.raw.g);
        soundList.add(R.raw.gs);


        Button button = (Button) findViewById(R.id.playSoundOne);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playRandomSound();
            }
        });

        /*soundStartOne = MediaPlayer.create(this,R.raw.a);


        Button playSoundOne = (Button) findViewById(R.id.playSoundOne);
        MediaPlayer finalSoundStartOne = soundStartOne;
        playSoundOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalSoundStartOne.start();
            }
        });*/
    }

    private void playRandomSound() {
        int randomInt = (new Random().nextInt(soundList.size()));
        int sound = soundList.get(randomInt);

        MediaPlayer mp = MediaPlayer.create(this, sound);
        mp.start();
    }

    private void configureSubmitButton(){
        answerInput = (EditText) findViewById(R.id.answerInput);
        submitButton = (Button) findViewById(R.id.submitAnswerOne);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer = answerInput.getText().toString();

                showToast(answer);

                if(answer.equals("c")){
                    showToast("correct");
                }
            }
        });
    }

    private void showToast(String text){
        Toast.makeText(levelOne.this, text, Toast.LENGTH_SHORT).show();
    }
}