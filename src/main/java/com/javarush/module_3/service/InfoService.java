package com.javarush.module_3.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.format.DateTimeFormatter;

public class InfoService {

    private final DateTimeFormatter dateTimeFormatter;
    private int gameCounter = 0;
    private final InetAddress inetAddress;

    public InfoService() throws UnknownHostException {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy | HH:mm");
        this.gameCounter++;
        this.inetAddress = InetAddress.getLocalHost();
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public int getGameCounter() {
        return gameCounter;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }
}
