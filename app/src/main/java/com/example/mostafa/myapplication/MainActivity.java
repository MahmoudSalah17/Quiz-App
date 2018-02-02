package com.example.mostafa.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup q1Group,q2Group,q5Group;
    private CheckedTextView q1,q2,q3,q4,q5;
    private RadioButton trueButton,storyBoardButton,frameButton;
    private CheckBox unityCB,unRealCB,anvilCB,GMCB;
    private Button submitButton,retakeButton;
    private EditText q4EditText;
    private int finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        submitButton=findViewById(R.id.submit_button);
        retakeButton=findViewById(R.id.retake_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retakeButton.setClickable(true);
                submitButton.setClickable(false);
                startGrading();
            }
        });
        retakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retakeButton.setClickable(false);
                submitButton.setClickable(true);
                Intent intent=getIntent();
                finish();
                startActivity(intent);
            }
        });
    }

    private void bindViews() {
        q1=findViewById(R.id.first_question);
        q2=findViewById(R.id.second_question);
        q3=findViewById(R.id.third_question);
        q4=findViewById(R.id.fourth_question);
        q5=findViewById(R.id.fifth_question);
        q1Group=findViewById(R.id.first_question_radio_group);
        q2Group=findViewById(R.id.second_question_radio_group);
        q5Group=findViewById(R.id.fifth_question_radio_group);
        unityCB=findViewById(R.id.checkBox);
        unRealCB=findViewById(R.id.checkBox2);
        anvilCB=findViewById(R.id.checkBox3);
        GMCB=findViewById(R.id.checkBox5);
        trueButton=findViewById(R.id.true_choice);
        storyBoardButton=findViewById(R.id.choice_story_board);
        frameButton=findViewById(R.id.choice_frame_1);
        q4EditText=findViewById(R.id.answer_edit_text);
    }

    private void startGrading() {
        finalResult=0;
        gradeFirstQuestion();
        gradeSecondQuestion();
        gradeThirdQuestion();
        gradeFourthQuestion();
        gradeFifthQuestion();
        Toast.makeText(this," Your result is "+finalResult+" out of 5",Toast.LENGTH_LONG).show();
    }

    private void gradeFifthQuestion() {
        frameButton.setTextColor(Color.GREEN);frameButton.setTypeface(null, Typeface.BOLD);
        if (frameButton.isChecked()) {
            finalResult++;
            q5.setCheckMarkDrawable(R.drawable.greentick);
        } else {
            q5.setCheckMarkDrawable(R.drawable.redcross);
            if (q5Group.getCheckedRadioButtonId()!= -1) {
                RadioButton radioButton = findViewById(q5Group.getCheckedRadioButtonId());
                radioButton.setTextColor(Color.RED);
                radioButton.setTypeface(null, Typeface.BOLD);
            }
        }
    }

    private void gradeFourthQuestion() {
        String answer=q4EditText.getText().toString().trim();
        if (answer.equals("graphical user interface")){
            finalResult++;
            q4.setCheckMarkDrawable(R.drawable.greentick);
        } else {
            q4.setCheckMarkDrawable(R.drawable.redcross);
        }
    }

    private void gradeThirdQuestion() {
        unRealCB.setTextColor(Color.GREEN);unityCB.setTextColor(Color.GREEN);GMCB.setTextColor(Color.GREEN);
        if (unRealCB.isChecked() && unityCB.isChecked()&& GMCB.isChecked() && !anvilCB.isChecked()){
            finalResult++;
            q3.setCheckMarkDrawable(R.drawable.greentick);
        }else {
            q3.setCheckMarkDrawable(R.drawable.redcross);
        }
    }

    private void gradeSecondQuestion() {
        storyBoardButton.setTextColor(Color.GREEN);storyBoardButton.setTypeface(null, Typeface.BOLD);
        if (storyBoardButton.isChecked()) {
            finalResult++;
            q2.setCheckMarkDrawable(R.drawable.greentick);
        } else {
            q2.setCheckMarkDrawable(R.drawable.redcross);
            if (q2Group.getCheckedRadioButtonId()!= -1) {
                RadioButton radioButton = findViewById(q2Group.getCheckedRadioButtonId());
                radioButton.setTextColor(Color.RED);
                radioButton.setTypeface(null, Typeface.BOLD);
            }
        }
    }

    private void gradeFirstQuestion() {
        trueButton.setTextColor(Color.GREEN);trueButton.setTypeface(null, Typeface.BOLD);
        if (trueButton.isChecked()) {
            finalResult++;
            q1.setCheckMarkDrawable(R.drawable.greentick);
        } else {
            q1.setCheckMarkDrawable(R.drawable.redcross);
            if (q1Group.getCheckedRadioButtonId()!= -1) {
                RadioButton radioButton = findViewById(q1Group.getCheckedRadioButtonId());
                radioButton.setTextColor(Color.RED);
                radioButton.setTypeface(null, Typeface.BOLD);
            }
        }
    }
}
