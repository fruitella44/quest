package com.javarush.module_3.servlet;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RestartServlet", value = "/restart")
public class RestartServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(RestartServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);
        currentSession.setMaxInactiveInterval(-1);
        LOGGER.info("Session active");

        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        LOGGER.debug("Start over. Send redirect login.jsp");
    }
}
