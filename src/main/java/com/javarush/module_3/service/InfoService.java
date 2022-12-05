package com.javarush.module_3.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InfoService {

    private int gameCounter;
    private final DateTimeFormatter dateTimeFormatter;
    private final InetAddress inetAddress;

    public InfoService() throws UnknownHostException {
        this.gameCounter = 0;
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        this.inetAddress = InetAddress.getLocalHost();
    }

    public LocalDateTime getDateTimeFormatter() {
        return LocalDateTime.parse("04.12.2022 19:39", dateTimeFormatter);
    }


    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public int getGameCounter() {
        return ++gameCounter;
    }
}
