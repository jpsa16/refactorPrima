package com.formacionbdi.springboot.app.productos.models.service.fabrica;

public interface LoggerDemo {
    void logMessage(String messageText);

    void logWarning(String messageText);

    void logError(String messageText);
}
