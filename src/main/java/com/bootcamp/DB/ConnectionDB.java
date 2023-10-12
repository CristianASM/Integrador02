package com.bootcamp.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private Connection cnx;
    public Connection connection() throws SQLException {
        try {
            cnx = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/integrador02",
                    "root",
                    "2010");

            System.out.println("Conexion abierta");
            System.out.println("++++++++++++++++++++++++++++++");
        }catch (SQLException e){
            System.out.println("Error al conectarse con la base de datos");
        }
        return cnx;
    }
    public void close() throws SQLException {
        if (cnx != null){
            if (!cnx.isClosed()){
                cnx.close();
                System.out.println("++++++++++++++++++++++++++++++");
                System.out.println("Conexion cerrada");
            }
        }
    }

}
