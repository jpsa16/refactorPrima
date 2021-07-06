package com.formacionbdi.springboot.app.productos.models.service.fabrica;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogToFile implements LoggerDemo {
    private File logFile = new File("C:\\logFile.txt");
    FileHandler fh = null;

    {
        try {
            fh = new FileHandler("C:\\logFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logMessage(String messageText) {
        String l = "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + messageText;

        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Logger logger = Logger.getLogger("MyLog1");
        logger.addHandler(fh);
        logger.log(Level.INFO, l);
    }

    @Override
    public void logWarning(String messageText) {
        String l = "warning " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + messageText;

        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Logger logger = Logger.getLogger("MyLog2");
        logger.addHandler(fh);
        logger.log(Level.INFO, l);
    }

    @Override
    public void logError(String messageText) {
        String l = "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + messageText;

        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Logger logger = Logger.getLogger("MyLog3");
        logger.addHandler(fh);
        logger.log(Level.INFO, l);
    }
}
