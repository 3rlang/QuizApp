package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizQuestion extends AppCompatActivity {

    RadioButton oneC;
    RadioButton twoA;
    RadioButton threeC;

    CheckBox checkBoxOne;
    CheckBox checkBoxTwo;
    CheckBox checkBoxThree;
    CheckBox checkBoxFour;

    RadioButton fiveA;
    RadioButton sixC;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);
    }

    public void submitQuiz(View view) {
        CharSequence resultsDisplay;
        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int answer6_score;
        int finalResult;

        //Get alias entered into the field
        editText = findViewById(R.id.state_Alias);
        String name = editText.getText().toString();

        // Check if a user name is written
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "We won't make fun of you; tell us what you were called, that one time :)", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }

        // Question 1 - Correct Answer is #C

        Boolean answerOne;
        oneC =  findViewById(R.id.oneC);
        answerOne = oneC.isChecked();
        if (answerOne) {
            answer1_score = 1;
        } else {
            answer1_score = 0;
        }

        // Question 2- Correct Answer is #A

        Boolean answerTwo;
        twoA = findViewById(R.id.twoA);
        answerTwo = twoA.isChecked();
        if (answerTwo) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }

        // Question 3 - Correct Answer is #C

        Boolean answerThree;
        threeC = findViewById(R.id.threeC);
        answerThree = threeC.isChecked();
        if (answerThree) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }

        // Question 4 - Correct Answer is #B and #D

        Boolean answer4_choice1;
        Boolean answer4_choice2;
        Boolean answer4_choice3;
        Boolean answer4_choice4;
        checkBoxOne =  this.findViewById(R.id.checkBoxOne);
        checkBoxTwo =  this.findViewById(R.id.checkBoxTwo);
        checkBoxThree = this.findViewById(R.id.checkBoxThree);
        checkBoxFour =  this.findViewById(R.id.checkBoxFour);
        answer4_choice1 = checkBoxOne.isChecked();
        answer4_choice2 = checkBoxTwo.isChecked();
        answer4_choice3 = checkBoxThree.isChecked();
        answer4_choice4 = checkBoxFour.isChecked();
        if (!answer4_choice1 && answer4_choice2 && !answer4_choice3 && answer4_choice4) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }

        // Question 5 - Correct Answer is #A

        Boolean answerFive;
        fiveA = findViewById(R.id.fiveA);
        answerFive = fiveA.isChecked();
        if (answerFive) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }

        // Question 6 - Correct Answer is #C

        Boolean answerSix;
        sixC = findViewById(R.id.sixC);
        answerSix = sixC.isChecked();
        if (answerSix) {
            answer6_score = 1;
        } else {
            answer6_score = 0;
        }

        //------------------------------------------------------------------------------------------
        // Final Score
        //------------------------------------------------------------------------------------------
        finalResult = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score + answer6_score;

        if (finalResult == 6) {
            resultsDisplay =  name   + "\n Thumbs Up! You got 6 out of 6 correct" ;

        } else if (finalResult <=2){
            resultsDisplay = name + "\n Hey, do try again. You got " + finalResult + " out of 6 correct";
        } else {
            resultsDisplay =  name + "\n Good start. You got " + finalResult + " out of 6 correct";
        }


        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();


    }
}