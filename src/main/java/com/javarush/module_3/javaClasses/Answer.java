package com.javarush.module_3.javaClasses;

import lombok.Builder;


@Builder
public class Answer {
    String text;
    Question nextQuestion;

}
