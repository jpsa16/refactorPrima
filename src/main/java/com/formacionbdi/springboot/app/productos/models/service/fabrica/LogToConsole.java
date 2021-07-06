package com.formacionbdi.springboot.app.productos.models.service.fabrica;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogToConsole implements LoggerDemo {

    @Override
    public void logMessage(String messageText) {
        String mensaje = "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + messageText;
        Logger logger = Logger.getLogger("MyLog1");

        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);
        logger.log(Level.INFO, mensaje);
    }

    @Override
    public void logWarning(String messageText) {
        String mensaje = "warning " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + messageText;
        Logger logger = Logger.getLogger("MyLog2");

        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);
        logger.log(Level.INFO, mensaje);
    }

    @Override
    public void logError(String messageText) {
        String mensaje = "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + messageText;
        Logger logger = Logger.getLogger("MyLog3");

        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);
        logger.log(Level.INFO, mensaje);
    }
}
