package com.formacionbdi.springboot.app.productos.models.service;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

//TODO: Esta muy acoplado y se podria implementar el patron fabrica para que mediante un identificador se obtenga la implementacion de tipo de log que se desea
public class Demo {
    private static boolean logToFile;
    private static boolean logToConsole;
    private static boolean logMessage;
    private static boolean logWarning;
    private static boolean logError;
    private static boolean logToDatabase; // TODO: ordenarlo
    private boolean initialized; // TODO: variable no se usa
    private static Map dbParams;
    private static Logger logger;

    public Demo(boolean logToFileParam, boolean logToConsoleParam, boolean logToDatabaseParam,
                boolean logMessageParam, boolean logWarningParam, boolean logErrorParam, Map dbParamsMap) {
        logger = Logger.getLogger("MyLog");
        logError = logErrorParam;
        logMessage = logMessageParam;
        logWarning = logWarningParam;
        logToDatabase = logToDatabaseParam;
        logToFile = logToFileParam;
        logToConsole = logToConsoleParam;
        dbParams = dbParamsMap;
    }

    public static void LogMessage(String messageText, boolean message, boolean warning, boolean error) throws Exception {
        messageText.trim();
        if (messageText == null || messageText.length() == 0) {
            return;
        }
        if (!logToConsole && !logToFile && !logToDatabase) {
            throw new Exception("Invalid configuration");
        }
        if ((!logError && !logMessage && !logWarning) || (!message && !warning && !error)) {
            throw new Exception("Error or Warning or Message must be specified");
        }

        //TODO: crea la conexion innecesarioamente si no le corresponde el log
        //TODO: Se deberia crear una clase conexion
        Connection connection = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", dbParams.get("userName"));
        connectionProps.put("password", dbParams.get("password"));

        connection = DriverManager.getConnection("jdbc:" + dbParams.get("dbms") + "://" + dbParams.get("serverName")
                + ":" + dbParams.get("portNumber") + "/", connectionProps);

        //TODO: las declaraciones dde variables se hacen al inicio
        //TODO: el nombre de variable t es muy corta y deberia tener un nombre apropiado
        int t = 0;
        if (message && logMessage) {
            t = 1;
        }

        if (error && logError) {
            t = 2;
        }

        if (warning && logWarning) {
            t = 3;
        }

        //TODO: se deberia usar un prepareStatement
        Statement stmt = connection.createStatement();

        //TODO: va crear el file sin importar que tipo de log es
        //TODO: la ruta deberia estar en un properties
        String l = null;
        File logFile = new File(dbParams.get("logFileFolder") + "/logFile.txt");
        if (!logFile.exists()) {
            logFile.createNewFile();
        }

        FileHandler fh = new FileHandler(dbParams.get("logFileFolder") + "/logFile.txt");
        ConsoleHandler ch = new ConsoleHandler();

        //TODO: no se usa la variable l
        if (error && logError) { // TODO: redundantes booleanos
            l = l + "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        }

        if (warning && logWarning) {
            l = l + "warning " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        }

        if (message && logMessage) {
            l = l + "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        }

        //TODO: apartir de este lado se tendria que usar la variable l para que pinte dependiendo que tipo de error es
        if (logToFile) {
            logger.addHandler(fh);
            logger.log(Level.INFO, messageText);
        }

        if (logToConsole) {
            logger.addHandler(ch);
            logger.log(Level.INFO, messageText);
        }

        if (logToDatabase) {
            stmt.executeUpdate("insert into Log_Values('" + message + "', " + String.valueOf(t) + ")");
        }
    }
}
