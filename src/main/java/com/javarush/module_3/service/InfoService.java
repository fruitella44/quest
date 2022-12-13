package com.javarush.module_3.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoService {
    private static final Logger LOGGER = LogManager.getLogger(InfoService.class);
    private static int GAME_COUNTER = 0;
    private static final SimpleDateFormat DATE_RELEASE_UPDATE = new SimpleDateFormat("dd.MM.yyyy");
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

    public static String getDateReleaseUpdate() {
        LOGGER.debug("Get pattern of date: " + DATE_RELEASE_UPDATE.toPattern());
        return DATE_RELEASE_UPDATE.format(new Date());
    }

    public InetAddress getIP_HOST_ADDRESS() {
        LOGGER.debug("MachineName and ipAddress: " + IP_HOST_ADDRESS);
        return IP_HOST_ADDRESS;
    }
}
