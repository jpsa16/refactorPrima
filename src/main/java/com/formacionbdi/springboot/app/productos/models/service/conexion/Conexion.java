package com.formacionbdi.springboot.app.productos.models.service.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection cnx = null;
    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=America/Lima&allowPublicKeyRetrieval=true&useSSL=false", "root", "root");
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }
    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }
}
