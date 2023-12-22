package com.example.mob_app_lab42;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CheatActivity extends AppCompatActivity {
    private String apiVersion = "API Level " + String.valueOf(Build.VERSION.SDK_INT);
    private CheatViewModel cheatViewModel;
    Button showAnswerButton;
    TextView showAPIversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        cheatViewModel = new ViewModelProvider(this).get(CheatViewModel.class);
        int cheat_count = getIntent().getIntExtra("cheat_count", 0);
        cheatViewModel.cheat_count = cheat_count;
        int arr_index = getIntent().getIntExtra("arr_index", 0);
        cheatViewModel.arr_index = arr_index;
        TextView showTrueAnswer = findViewById(R.id.textViewTrueAnswer);
        showTrueAnswer.setGravity(Gravity.CENTER_HORIZONTAL);
        showTrueAnswer.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        showAPIversion = findViewById(R.id.textViewAPIversion);
        showAPIversion.setText(apiVersion);
        TextView showCheatCount = findViewById(R.id.textViewCheatCount);
        showCheatCount.setText("Кол-во подсказок " + (3 - cheatViewModel.cheat_count));
        if (cheatViewModel.cheat_count >= 3) {
            View showAnswerButton = findViewById(R.id.buttonShowAnswer);
            showAnswerButton.setEnabled(false);
            showTrueAnswer.setText("Подсказки кончились");
            showCheatCount.setText("Кол-во подсказок: 0");
            Toast.makeText(CheatActivity.this, "Подсказки кончились", Toast.LENGTH_SHORT).show();
        }
        else {
            showTrueAnswer.setText("Вы хотите узнать правильный ответ?");
        }
        showAnswerButton = findViewById(R.id.buttonShowAnswer);
        showAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cheatViewModel.arr_index == 0) {
                    cheatViewModel.cheat_count++;
                    showTrueAnswer.setText("False");
                    showCheatCount.setText("Кол-во подсказок: " + (3 - cheatViewModel.cheat_count));
                }
                else if (cheatViewModel.arr_index == 1) {
                    cheatViewModel.cheat_count++;
                    showTrueAnswer.setText("True");
                    showCheatCount.setText("Кол-во подсказок: " + (3 - cheatViewModel.cheat_count));
                }
                View showAnswerButton = findViewById(R.id.buttonShowAnswer);
                showAnswerButton.setEnabled(false);
            }
        });
    }
}