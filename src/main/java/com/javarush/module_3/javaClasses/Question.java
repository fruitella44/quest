package com.javarush.module_3.javaClasses;

import lombok.Builder;
import java.util.List;

@Builder
public class Question {
    String text;
    List<Answer> answerList;
    boolean isWin;
    boolean defeat;

    public List<Answer> getAnswerList() {
        return answerList;
    }
}
