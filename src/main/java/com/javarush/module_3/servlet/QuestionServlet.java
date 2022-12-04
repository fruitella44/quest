package com.javarush.module_3.servlet;

import com.javarush.module_3.service.Questions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private int HIT_COUNTER = 0;
    private static final Logger LOGGER = LogManager.getLogger(QuestionServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        LOGGER.info("Session active");

        if (!currentSession.getAttributeNames().hasMoreElements()) {
            try {
                setAttributeCurrentSession(currentSession);
            } catch (Exception exception) {
                LOGGER.error("Session has not attributes: " + exception);
                throw new RuntimeException(exception);
            }
        }


        String name = req.getParameter("name");
        currentSession.setAttribute("name", name);
        currentSession.setAttribute("pageNumber", 1);
        LOGGER.debug("Added attributes: [name=" + name + " pageNumber attributes: [1]]");

        resp.sendRedirect("/question.jsp");
        LOGGER.debug("Send redirect question.jsp");
    }


    private void setAttributeCurrentSession(HttpSession currentSession) throws Exception {
        Questions questions = new Questions();
        Object getAttributeMap = questions.getQuestionService();

        InetAddress inetAddress = InetAddress.getLocalHost();
        String ip = inetAddress.getHostAddress();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String time = dateTimeFormatter.format(LocalTime.now());

        HIT_COUNTER++;
        currentSession.getAttribute("gameCounter");

        currentSession.setAttribute("questions", getAttributeMap);

        LOGGER.debug("Added attributes: [" + questions.getQuestionService() + "]");

        currentSession.setAttribute("ip", ip);
        currentSession.setAttribute("time", time);
        currentSession.setAttribute("gameCounter", HIT_COUNTER);
        LOGGER.debug("Added attributes: [ip=" + ip + " time=" + time + " gameCounter=" + HIT_COUNTER + "]");

    }
}
