package com.javarush.module_3.servlet;

import com.javarush.module_3.pojoClass.InfoService;
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

@WebServlet(name = "QuestionServlet", value = "/question")
public class QuestionServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(QuestionServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        LOGGER.info("Session active");

        if (!currentSession.getAttributeNames().hasMoreElements()) {
            try {
                setAttributeCurrentSession(currentSession);
            } catch (Exception exception) {
                LOGGER.error("Session has no attributes after redirect to question.jsp: " + exception);
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
        QuestionService questions = new QuestionService();
        InfoService infoService = new InfoService();

        Object getAttributeQuestion = questions.getQuestionService();
        LOGGER.debug("Clone hashMap into concurrent Map");

        Object ip = infoService.getIP_HOST_ADDRESS();
        Object curDateRunApplication = InfoService.getCurrentDateRunApplication();
        Object gameCounter = InfoService.getGameCounter();

        currentSession.getAttribute("gameCounter");

        currentSession.setAttribute("questions", getAttributeQuestion);
        LOGGER.debug("Added attributes: [" + questions.getQuestionService() + "]");

        currentSession.setAttribute("ipAddress", ip);
        currentSession.setAttribute("curDateRunApplication", curDateRunApplication);
        currentSession.setAttribute("gameCounter", gameCounter);
        LOGGER.debug("Added attributes: [ipAddress=" + ip + " curDateRunApplication=" + curDateRunApplication + " gameCounter=" + gameCounter + "]");

    }
}
