package com.javarush.module_3.servlet;

import com.javarush.module_3.pojoClass.QuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

import static java.util.Objects.isNull;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(LogicServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        LOGGER.info("Session active");

        String answer = req.getParameter("answer");
        Map<Integer, QuestionService> pages = (Map<Integer, QuestionService>) currentSession.getAttribute("questions");
        int pageNumber = (int) currentSession.getAttribute("pageNumber") + 1;
        LOGGER.debug("Session pageNumber attributes: [" + pageNumber + "]");

        if (isNull(answer)) {
            getServletContext().getRequestDispatcher("/question.jsp").forward(req, resp);
            LOGGER.debug("User didn't pick an answer. Answer=" + null);
            return;

        } else if (answer.equals("reject") || pageNumber > pages.size()) {
            resp.sendRedirect("/end.jsp?answer=" + answer);
            LOGGER.debug("Redirect by " + answer);
            return;
        }

        currentSession.setAttribute("pageNumber", pageNumber);
        resp.sendRedirect("/question.jsp");
        LOGGER.debug("Send redirect question.jsp");
    }
}


