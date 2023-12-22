package com.example.mob_app_lab42;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private QuizViewModel quizViewModel;
    public Button trueButton, falseButton, nextButton, cheatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView question = findViewById(R.id.textViewQuestion);
        question.setGravity(Gravity.CENTER_HORIZONTAL);
        question.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        trueButton = findViewById(R.id.buttonTrue);
        falseButton = findViewById(R.id.buttonFalse);
        nextButton = findViewById(R.id.buttonNext);
        cheatButton = findViewById(R.id.buttonCheat);
        quizViewModel = new ViewModelProvider(this).get(QuizViewModel.class);
        question.setText(quizViewModel.question_value);
        View nextButton = findViewById(R.id.buttonNext);
        nextButton.setEnabled(false);
        if (quizViewModel.cheat_count == 3) {
            cheatButton.setEnabled(false);
        }

        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CheatActivity.class);
                intent.putExtra("arr_index", quizViewModel.arr_index);
                intent.putExtra("cheat_count", quizViewModel.cheat_count);
                quizViewModel.cheat_count++;
                startActivity(intent);
            }
        });

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ((Button)view).getText().toString(), Toast.LENGTH_SHORT).show();
                View trueButton = findViewById(R.id.buttonTrue);
                trueButton.setEnabled(false);
                View falseButton = findViewById(R.id.buttonFalse);
                falseButton.setEnabled(false);
                View nextButton = findViewById(R.id.buttonNext);
                nextButton.setEnabled(true);
                if (quizViewModel.arr_index == 1) {
                    quizViewModel.true_answers++;
                }
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ((Button)view).getText().toString(), Toast.LENGTH_SHORT).show();
                View trueButton = findViewById(R.id.buttonTrue);
                trueButton.setEnabled(false);
                View falseButton = findViewById(R.id.buttonFalse);
                falseButton.setEnabled(false);
                View nextButton = findViewById(R.id.buttonNext);
                nextButton.setEnabled(true);
                if (quizViewModel.arr_index == 0) {
                    quizViewModel.true_answers++;
                }
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ((Button)view).getText().toString(), Toast.LENGTH_SHORT).show();
                View trueButton = findViewById(R.id.buttonTrue);
                trueButton.setEnabled(true);
                View falseButton = findViewById(R.id.buttonFalse);
                falseButton.setEnabled(true);
                quizViewModel.question_count++;
                if (quizViewModel.question_count == quizViewModel.question_limit) {
                    String answers_count = "Правильных ответов: " + quizViewModel.true_answers;
                    Toast.makeText(MainActivity.this, answers_count, Toast.LENGTH_LONG).show();
                    view.setEnabled(false);
                    trueButton.setEnabled(false);
                    falseButton.setEnabled(false);
                }
                else {
                    quizViewModel.question_value = quizViewModel.getQuestion_value();
                    question.setText(quizViewModel.question_value);
                    view.setEnabled(false);
                }
            }
        });
    }
}