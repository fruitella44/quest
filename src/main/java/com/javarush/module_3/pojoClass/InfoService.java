package com.javarush.module_3.pojoClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoService {
    private static final Logger LOGGER = LogManager.getLogger(InfoService.class);
    private static int GAME_COUNTER = 0;
    private static final SimpleDateFormat CURRENT_DATE_RUN_APPLICATION = new SimpleDateFormat("dd.MM.yyyy");
    private static final InetAddress IP_HOST_ADDRESS;

    static {
        try {
            IP_HOST_ADDRESS = InetAddress.getLocalHost();
        } catch (UnknownHostException exception) {
            LOGGER.error("Unknown hostAddress " + exception);
            throw new RuntimeException(exception);
        }
    }


    public static int getGameCounter() {
        LOGGER.info("Increase gameCounter");
        return ++GAME_COUNTER;
    }

    public static String getCurrentDateRunApplication() {
        LOGGER.debug("Get pattern of date: " + CURRENT_DATE_RUN_APPLICATION.toPattern());
        return CURRENT_DATE_RUN_APPLICATION.format(new Date());
    }

    public String getIP_HOST_ADDRESS() {
        LOGGER.debug("IP Address: " + IP_HOST_ADDRESS);
        return "" + IP_HOST_ADDRESS.getHostAddress();
    }
}
