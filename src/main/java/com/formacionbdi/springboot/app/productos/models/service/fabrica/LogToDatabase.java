package com.formacionbdi.springboot.app.productos.models.service.fabrica;

import com.formacionbdi.springboot.app.productos.models.service.conexion.Conexion;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.util.Date;

public class LogToDatabase implements LoggerDemo {


    @Override
    public void logMessage(String messageText) {
        String mensaje = "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + messageText.trim();
        try {
            PreparedStatement consulta;
            consulta = Conexion.obtener().prepareStatement("INSERT INTO log_values" + "(mensaje, valor) VALUES(?, ?)");
            consulta.setString(1, mensaje);
            consulta.setInt(2, 1);
            consulta.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void logWarning(String messageText) {
        String mensaje = "warning " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + messageText.trim();
        try {
            PreparedStatement consulta;
            consulta = Conexion.obtener().prepareStatement("INSERT INTO log_values" + "(mensaje, valor) VALUES(?, ?)");
            consulta.setString(1, mensaje);
            consulta.setInt(2, 3);
            consulta.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void logError(String messageText) {
        String mensaje = "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + messageText.trim();
        try {
            PreparedStatement consulta;
            consulta = Conexion.obtener().prepareStatement("INSERT INTO log_values" + "(mensaje, valor) VALUES(?, ?)");
            consulta.setString(1, mensaje);
            consulta.setInt(2, 2);
            consulta.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
