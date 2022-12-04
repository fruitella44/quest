package com.javarush.module_3.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class QuestionsTest {

    @Test
    void checkNullArgumentQuestions() {
        assertThrows(IllegalArgumentException.class, () -> new Questions(null, null, null, null));
    }

    @Test
    void checkIllegalArgumentExceptionMessage() {
        String expectedMessage = "Value cannot be null";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException(expectedMessage);
        });

        assertEquals(expectedMessage, exception.getMessage());
    }


    @Mock
    Map questionsMap;

    @Test
    void getQuestionsMap() {
        questionsMap = mock(Map.class);
        int expectedSize = 3;

        doReturn(expectedSize).when(questionsMap).size();
        assertEquals(expectedSize, questionsMap.size());
    }

    @Test
    void checkMapValue() {
        String expectedMessage = "Ты потерял память. Принять вызов НЛО?";
        int expectedKey = 1;

        doReturn(expectedMessage).when(questionsMap).get(any(int.class));
        assertEquals(expectedMessage, questionsMap.get(expectedKey));
    }

}
