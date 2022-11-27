package com.javarush.module_3.servlet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
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

    @Mock
    HttpSession session;

    @Mock
    QuestionServlet servlet = new QuestionServlet();

    @Test
    void checkParamName() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // mock the returned value of request.getParameterMap()
        Mockito.when(request.getParameter("name")).thenReturn("Test");
//        Mockito.when(response.getWriter()).thenReturn(new PrintWriter(writer));
//
//        servlet.doGet(request, response);
//        assertThat(writer.toString()).isEqualTo("Test");
    }
}