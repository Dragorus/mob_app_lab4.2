package com.example.mob_app_lab42;

import android.view.View;
import android.widget.TextView;

public class QuestionDB {
    public static String GetQuestion(int ArrayIndex, int QuestionIndex) {
        String[] TrueQuestions = new String[]{
                "Одним из признаков государства является территория",
                "Конституция РФ была принята 12 декабря 1993 года",
                "Правоспособность у физического лица возникает с момента рождения",
                "Право на жизнь относится к личным правам, закрепленным Коституцией РФ",
                "Право на неприкосновенность личности относится к личным правам, закрепленным Коституцией РФ",
        };
        String[] FalseQuestions = new String[]{
                "Одним из признаков государства является правитель",
                "Конституция РФ была принята 10 ноября 1991 года",
                "Правоспособность у физического лица возникает с 18 лет",
                "Право на отдых относится к личным правам, закрепленным Коституцией РФ",
                "Право на жилище относится к личным правам, закрепленным Коституцией РФ",
        };
        if (ArrayIndex == 0) {
            return FalseQuestions[QuestionIndex];
        } else if (ArrayIndex == 1) {
            return TrueQuestions[QuestionIndex];
        }
        else return "";
    }
}
