package com.javarush.module_3.servlet;


import com.javarush.module_3.javaClasses.Answer;
import com.javarush.module_3.javaClasses.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Question", value = "/question")
public class QuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        req.setAttribute("name", currentSession.getAttribute("name"));
        resp.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);
        Question question = new Question();
        Answer answer = new Answer();

        String question1 = req.getParameter("question1");
        currentSession.setAttribute("answer", answer.getAccept());
        currentSession.setAttribute("question1", question.getQuestion1());

        String question2 = req.getParameter("question2");
        currentSession.setAttribute("question2", question.getQuestion2());

        String question3 = req.getParameter("question3");
        currentSession.setAttribute("question3", question.getQuestion3());

        getServletContext().getRequestDispatcher("/question.jsp").forward(req, resp);
    }

}
