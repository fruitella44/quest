package com.javarush.module_3.servlet;

import com.javarush.module_3.javaClasses.Questions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "QuestionServlet", value = "/question")
public class QuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        if (!currentSession.getAttributeNames().hasMoreElements()) {
            try {
                setAttributeCurrentSession(currentSession);
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }


        String name = req.getParameter("name");
        currentSession.setAttribute("name", name);
        currentSession.setAttribute("pageNumber", 1);

        resp.sendRedirect("/question.jsp");
    }


    private void setAttributeCurrentSession(HttpSession currentSession) throws Exception {
        Questions questions = new Questions();
        Object getAttributeMap = questions.getQuestionsMap();

        InetAddress inetAddress = InetAddress.getLocalHost();
        String ip = inetAddress.getHostAddress();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String time = dateTimeFormatter.format(LocalTime.now());

        currentSession.setAttribute("questions", getAttributeMap);
        currentSession.setAttribute("ip", ip);
        currentSession.setAttribute("time", time);
    }

}
