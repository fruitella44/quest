package com.javarush.module_3.javaClasses;

import java.util.List;
import java.util.Scanner;

public class QuestLogic {
    private Scanner scanner = new Scanner(System.in);

    public void questionAndAnswer() {
        Question winQuestion = Question.builder()
                .text("Тебя вернули домой. Победа!")
                .isWin(true)
                .build();

        Question lieQuestion = Question.builder()
                .text("Твою ложь разоблачи. Поражение!")
                .defeat(true)
                .build();

        Question negotiation = Question.builder()
                .text("Ты не пошел на переговоры. Поражение!")
                .defeat(true)
                .build();

        Question rejectChallenge = Question.builder()
                .text("Ты отклонил вызов. Поражение")
                .defeat(true)
                .build();

        Question whoAreYou = Question.builder()
                .text("Ты поднялся на мостик. Ты кто?")
                .answerList(List.of(
                        Answer.builder()
                                .text("Рассказать правду о себе")
                                .nextQuestion(winQuestion)
                                .build(),
                        Answer.builder()
                                .text("Солгать о себе")
                                .nextQuestion(lieQuestion)
                                .build()

                ))
                .build();

        Question climbUpBridge = Question.builder()
                .text("Ты принял вызов. Поднимешься нам мостик к капитану?")
                .answerList(List.of(
                        Answer.builder()
                                .text("Подняться на мостик")
                                .nextQuestion(whoAreYou)
                                .build(),
                        Answer.builder()
                                .text("Отказать подняться на мостик")
                                .nextQuestion(negotiation)
                                .build()
                ))
                .build();

        Question challenge = Question.builder()
                .text("Ты потерял память. Принять вызов НЛО?")
                .answerList(List.of(
                        Answer.builder()
                                .text("Принять вызов")
                                .nextQuestion(climbUpBridge)
                                .build(),
                        Answer.builder()
                                .text("Отклонить вызов")
                                .nextQuestion(rejectChallenge)
                                .build()
                ))
                .build();

        Question currentQuestion = challenge;
        while (!(currentQuestion.isWin && currentQuestion.defeat)) {
            System.out.println(currentQuestion.text);

            for (int i = 0; i < currentQuestion.answerList.size(); i++) {
                System.out.println("-> " + i + ":" + currentQuestion.answerList.get(i).text);
            }

            System.out.println("Ваш выбор:");
            int inputChoice = scanner.nextInt();
            currentQuestion = currentQuestion.answerList.get(inputChoice).nextQuestion;

        }

    }
}
