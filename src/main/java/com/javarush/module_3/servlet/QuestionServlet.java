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
import java.util.Map;

@WebServlet(name = "QuestionServlet", value = "/question")
public class QuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        if (!currentSession.getAttributeNames().hasMoreElements()) {
            initSession(currentSession);
        }

        String name = req.getParameter("name");
        currentSession.setAttribute("name", name);
        currentSession.setAttribute("pageNumber", 1);

        resp.sendRedirect("/question.jsp");
    }

    protected void initSession(HttpSession session) throws IOException {
        Map<Integer, Questions> questions = Map.ofEntries(
                Map.entry(1, new Questions("Ты потерял память. Принять вызов НЛО?", "Ты отклонил вызов. Поражение!", "Принять вызов", "Отклонить вызов")),
                Map.entry(2, new Questions("Ты принял вызов. Подняться на мостик к капитану?", "Ты не пошёл на переговоры. Поражение!", "Подняться на мостик", "Отказаться подниматься на мостик")),
                Map.entry(3, new Questions("Ты поднялся на мостик. Кто ты?", "Твою ложь разоблачили. Поражение!", "Рассказать правду о себе", "Солгать о себе"))
        );

        session.setAttribute("questions", questions);

        InetAddress localHost = InetAddress.getLocalHost();
        String ip = localHost.getHostAddress();

        session.setAttribute("ip", ip);
        session.setAttribute("gameCounter", 0);
    }
}
