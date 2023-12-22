package com.example.mob_app_lab42;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.view.ActionMode;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.security.auth.callback.Callback;

public class QuizViewModel extends ViewModel {
    int question_count;
    int question_limit;
    int true_answers;
    String question_value;
    int arr_index, q_index;
    int cheat_count;

    public QuizViewModel() {
        question_value = getQuestion_value();
        true_answers = 0;
        question_limit = 3;
        question_count = 0;
        cheat_count = 0;
    }

    public String getQuestion_value() {
        String question_value;
        arr_index = ThreadLocalRandom.current().nextInt(0, 1 + 1);
        q_index = ThreadLocalRandom.current().nextInt(0, 5 + 1);
        question_value = QuestionDB.GetQuestion(arr_index, q_index);
        return question_value;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
