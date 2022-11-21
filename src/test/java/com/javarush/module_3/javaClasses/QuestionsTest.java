package com.javarush.module_3.javaClasses;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class QuestionsTest {

    @Mock
    Map<Integer, Questions> questionsMap;

    @Test
    void getQuestionsMap() {
        questionsMap = Mockito.mock(Map.class);
        int expectedSize = 3;

        Mockito.doReturn(expectedSize).when(questionsMap).size();
        assertEquals(expectedSize, questionsMap.size());
    }
}