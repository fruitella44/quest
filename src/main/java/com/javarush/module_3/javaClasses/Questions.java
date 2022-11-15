package com.javarush.module_3.javaClasses;

public class Questions {
    private String question;
    private String endGame;
    private String accept;
    private String reject;


    public Questions(String question, String endGame, String accept, String reject) {
        this.question = question;
        this.endGame = endGame;
        this.accept = accept;
        this.reject = reject;

    }

    public String getQuestion() {
        return question;
    }

    public String getEndGame() {
        return endGame;
    }

    public String getAccept() {
        return accept;
    }

    public String getReject() {
        return reject;
    }



}
