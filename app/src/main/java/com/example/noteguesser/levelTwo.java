package com.example.noteguesser;





//can copy paste code from level 1 just change the mp3 files lol






import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class levelTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);
        getSupportActionBar().hide();

        configureLevelsButton();
    }

    private void configureLevelsButton(){
        Button backLevelsOneButton = (Button) findViewById(R.id.backLevelsTwo);
        backLevelsOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}