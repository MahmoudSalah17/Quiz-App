package com.example.mostafa.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Mostafa on 2/2/2018.
 */

public class StartScreen extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_start_screen);
        Button startButton=findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startQuiz=new Intent(StartScreen.this,MainActivity.class);
                startActivity(startQuiz);
            }
        });

    }
}
