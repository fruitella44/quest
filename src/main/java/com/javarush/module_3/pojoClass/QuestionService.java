package com.javarush.module_3.pojoClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.isNull;

public class QuestionService {
    private static final Logger LOGGER = LogManager.getLogger(QuestionService.class);
    private final Map<Integer, QuestionService> questionService = new HashMap<>();
    private String question;
    private String endGame;
    private String accept;
    private String reject;


    public QuestionService() {
        questionService.put(1, new QuestionService("Ты потерял память. Принять вызов НЛО?",
                "Ты отклонил вызов. Поражение!", "Согласиться", "Отказаться"));

        questionService.put(2, new QuestionService("Ты принял вызов. Подняться на мостик к капитану?",
                "Ты не пошёл на переговоры. Поражение!", "Согласиться", "Отказаться"));

        questionService.put(3, new QuestionService("Ты поднялся на мостик, кто ты? Рассказать правду о себе?",
                "Твою ложь разоблачили. Поражение!", "Согласиться", "Отказаться"));

        LOGGER.info("Starting application. Values size: " + getQuestionService().size());
    }

    public QuestionService(String question, String endGame, String accept, String reject) {
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

    public Map<Integer, QuestionService> getQuestionService() {
        return new ConcurrentHashMap<>(questionService);
    }


    @Override
    public String toString() {
        return "Questions{" +
                "question='" + question + '\'' +
                ", endGame='" + endGame + '\'' +
                ", accept='" + accept + '\'' +
                ", reject='" + reject + '\'' +
                ", questionsMap=" + questionService +
                '}';
    }
}
