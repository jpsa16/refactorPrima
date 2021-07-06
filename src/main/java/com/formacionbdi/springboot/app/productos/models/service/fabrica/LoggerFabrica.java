package com.formacionbdi.springboot.app.productos.models.service.fabrica;

import org.springframework.stereotype.Service;

@Service
public class LoggerFabrica {

    public LoggerDemo getLoggerDemo(String tipoLog) {
        if (tipoLog.equals("logToConsole")) {
            return new LogToConsole();
        } else if (tipoLog.equals("logToFile")) {
            return new LogToFile();
        } else if (tipoLog.equals("logToDatabase")) {
            return new LogToDatabase();
        } else {
            return null;
        }
    }
}
