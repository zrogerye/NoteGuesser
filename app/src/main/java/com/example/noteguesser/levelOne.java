package com.example.noteguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class levelOne extends AppCompatActivity {

    String answer;
    EditText answerInput;
    Button submitButton;
    int listPos;
    int soundId;
    List<Integer> soundList;
    Map<Integer, String> soundMap;

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

        //map is for comparing user input to correct answer
        soundMap = new HashMap<Integer,String>();
        soundMap.put(R.raw.a, "a");
        soundMap.put(R.raw.b, "b");
        soundMap.put(R.raw.bb, "bb");
        soundMap.put(R.raw.c, "c");
        soundMap.put(R.raw.cs, "cs");
        soundMap.put(R.raw.d, "d");
        soundMap.put(R.raw.e, "e");
        soundMap.put(R.raw.eb, "eb");
        soundMap.put(R.raw.f, "f");
        soundMap.put(R.raw.fb, "fb");
        soundMap.put(R.raw.g, "g");
        soundMap.put(R.raw.gs, "gs");

        //arraylist is for playing a random sound
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
    }

    private void playRandomSound() {
        listPos = (new Random().nextInt(soundList.size()));
        soundId = soundList.get(listPos);
        int sound = soundList.get(listPos);

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

                //showToast(answer);


                //oh shit maybe i need a map
                if(answer.equals(soundMap.get(soundId))){
                    showToast("correct");
                } else{
                    showToast("incorrect, correct answer is: " + soundMap.get(soundId));
                }
            }
        });
    }

    private void showToast(String text){
        Toast.makeText(levelOne.this, text, Toast.LENGTH_SHORT).show();
    }
}