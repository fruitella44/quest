package com.javarush.module_3.javaClasses;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class Questions {
    private String question;
    private String endGame;
    private String accept;
    private String reject;
    private final Map<Integer, Questions> questionsMap = new HashMap<>();


    public Questions() {
        questionsMap.put(1, new Questions("Ты потерял память. Принять вызов НЛО?", "Ты отклонил вызов. Поражение!", "Принять вызов", "Отклонить вызов"));
        questionsMap.put(2, new Questions("Ты принял вызов. Подняться на мостик к капитану?", "Ты не пошёл на переговоры. Поражение!", "Подняться на мостик", "Отказаться подниматься на мостик"));
        questionsMap.put(3, new Questions("Ты поднялся на мостик. Кто ты?", "Твою ложь разоблачили. Поражение!", "Рассказать правду о себе", "Солгать о себе"));
    }

    public Questions(String question, String endGame, String accept, String reject) {
        if (isNull(question)) {
            throw new IllegalArgumentException("Value cannot be null");
        } else if (isNull(endGame)) {
            throw new IllegalArgumentException("Value cannot be null");
        } else if (isNull(accept)) {
            throw new IllegalArgumentException("Value cannot be null");
        } else if (isNull(reject)) {
            throw new IllegalArgumentException("Value cannot be null");
        }

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

    public Map<Integer, Questions> getQuestionsMap() {
        return questionsMap;
    }


}
