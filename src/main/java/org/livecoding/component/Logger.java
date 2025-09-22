package org.livecoding.component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public enum Level {INFO, WARN, ERROR}

    private final Level minLevel;
    private final DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Logger(Level minLevel) {
        this.minLevel = minLevel;
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void warn(String message) {
        log(Level.WARN, message);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    private void log(Level level, String message) {
        if (level.ordinal() < minLevel.ordinal()) return;

        var time = LocalDateTime.now().format(formater);
        System.out.printf("[%s] [%s] %s%n", time, level, message);
    }
}
