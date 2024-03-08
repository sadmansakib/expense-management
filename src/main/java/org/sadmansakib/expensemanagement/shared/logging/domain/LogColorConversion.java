package org.sadmansakib.expensemanagement.shared.logging.domain;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;


public class LogColorConversion extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        if (iLoggingEvent.getLevel().equals(Level.ERROR)) {
            return "\u001B[31m" + iLoggingEvent.getLevel() + "\u001B[0m";
        }
        if (iLoggingEvent.getLevel().equals(Level.WARN)) {
            return "\u001B[33m" + iLoggingEvent.getLevel() + "\u001B[0m";
        }
        if (iLoggingEvent.getLevel().equals(Level.INFO)) {
            return "\u001B[32m" + iLoggingEvent.getLevel() + "\u001B[0m";
        }
        if (iLoggingEvent.getLevel().equals(Level.DEBUG)) {
            return "\u001B[34m" + iLoggingEvent.getLevel() + "\u001B[0m";
        }
        return iLoggingEvent.getLevel().toString();
    }
}
