package com.javarush.module_3.servlet;

import com.javarush.module_3.javaClasses.Questions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String variant = req.getParameter("variant");

        HttpSession currentSession = req.getSession();
        Map<Integer, Questions> pages = (Map<Integer, Questions>) currentSession.getAttribute("questions");
        int pageNumber = (int) currentSession.getAttribute("pageNumber") + 1;

        if (variant.equals("no") || pageNumber > pages.size()) {
            resp.sendRedirect("/end.jsp?variant=" + variant);
            return;
        }
        currentSession.setAttribute("pageNumber", pageNumber);
        resp.sendRedirect("/question.jsp");
    }
}