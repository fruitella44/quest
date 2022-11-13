package com.javarush.module_3.javaClasses;


import java.util.HashSet;
import java.util.Set;

public class Answer {
    private String accept = "Принять";
    private String reject = "Отказаться";
    private Set<String> answers = new HashSet<>();
    private boolean isWin = true;
    private boolean isLose = false;

    public String getAccept() {
        return accept;
    }

    public String getReject() {
        return reject;
    }

    public boolean isWin() {
        return isWin;
    }

    public boolean isLose() {
        return isLose;
    }

    public Set<String> addAnswers() {
        answers.add(accept);
        answers.add(reject);

        return answers;
    }
}
