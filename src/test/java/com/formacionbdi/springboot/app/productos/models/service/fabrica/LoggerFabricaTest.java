package com.formacionbdi.springboot.app.productos.models.service.fabrica;

import com.formacionbdi.springboot.app.productos.SpringbootApplication;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringbootApplication.class)
public class LoggerFabricaTest  {
    LoggerFabrica loggerFabrica = new LoggerFabrica();

    @Test
    public void testLogToConsole() {
        LoggerDemo response = loggerFabrica.getLoggerDemo("logToConsole");
        Assert.assertTrue(response instanceof LogToConsole);
    }

    @Test
    public void testLogToFile() {
        LoggerDemo response = loggerFabrica.getLoggerDemo("logToFile");
        Assert.assertTrue(response instanceof LogToFile);
    }

    @Test
    public void testLogToDatabase() {
        LoggerDemo response = loggerFabrica.getLoggerDemo("logToDatabase");
        Assert.assertTrue(response instanceof LogToDatabase);
    }

}