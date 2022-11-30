package com.javarush.module_3.servlet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class QuestionServletTest {
    private final static String path = "/question.jsp";

    @Test
    void checkAttributesElements() throws ServletException, IOException {
        final QuestionServlet servlet = new QuestionServlet();
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final HttpSession session = mock(HttpSession.class);

        Mockito.when(session.getAttributeNames().hasMoreElements()).thenReturn(null);
        servlet.doGet(request, response);

        Mockito.verify(request).getSession();
        Mockito.verify(response).sendRedirect(path);
    }
}