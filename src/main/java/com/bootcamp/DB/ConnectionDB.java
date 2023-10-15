package com.bootcamp.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private Connection cnx;
    private static ConnectionDB instance; //Patron singleton
    private ConnectionDB() {
    }
    public static ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }

    public Connection connection() throws SQLException {
        if (cnx == null || cnx.isClosed()) { // Aca abro la conexion y evito que se abra mas de una vez
            try {
                cnx = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/integrador02",
                        "root",
                        "2010");

                System.out.println("Conexion abierta");
                System.out.println("++++++++++++++++++++++++++++++");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cnx;
    }
    public void close() throws SQLException { // Cierro la conexion
        if (cnx != null){
            if (!cnx.isClosed()){
                cnx.close();
                System.out.println("++++++++++++++++++++++++++++++");
                System.out.println("Conexion cerrada");
            }
        }
    }

}
