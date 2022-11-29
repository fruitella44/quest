package com.javarush.module_3.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class Questions {
    private String question;
    private String endGame;
    private String accept;
    private String reject;
    private final Map<Integer, Questions> questionsMap = new HashMap<>();
    private static final Logger LOGGER = LogManager.getLogger(Questions.class);


    public Questions() {
        questionsMap.put(1, new Questions("Ты потерял память. Принять вызов НЛО?", "Ты отклонил вызов. Поражение!", "Принять вызов", "Отклонить вызов"));
        questionsMap.put(2, new Questions("Ты принял вызов. Подняться на мостик к капитану?", "Ты не пошёл на переговоры. Поражение!", "Подняться на мостик", "Отказаться подниматься на мостик"));
        questionsMap.put(3, new Questions("Ты поднялся на мостик. Кто ты?", "Твою ложь разоблачили. Поражение!", "Рассказать правду о себе", "Солгать о себе"));

        LOGGER.info("Starting application. Values size: " + getQuestionsMap().size());
    }

    public Questions(String question, String endGame, String accept, String reject) {
        if (isNull(question)) {
            LOGGER.error("question value is null");
            throw new IllegalArgumentException("Value cannot be null");
        } else if (isNull(endGame)) {
            LOGGER.error("endGame value is null");
            throw new IllegalArgumentException("Value cannot be null");
        } else if (isNull(accept)) {
            LOGGER.error("accept value is null");
            throw new IllegalArgumentException("Value cannot be null");
        } else if (isNull(reject)) {
            LOGGER.error("reject value is null");
            throw new IllegalArgumentException("Value cannot be null");
        }

        this.question = question;
        this.endGame = endGame;
        this.accept = accept;
        this.reject = reject;

        LOGGER.debug("Initialized values: [" + question + " " + endGame + " " + accept + " " + reject + "]");
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


    @Override
    public String toString() {
        return "Questions{" +
                "question='" + question + '\'' +
                ", endGame='" + endGame + '\'' +
                ", accept='" + accept + '\'' +
                ", reject='" + reject + '\'' +
                ", questionsMap=" + questionsMap +
                '}';
    }
}
