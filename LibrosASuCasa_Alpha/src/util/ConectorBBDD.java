package util;

import java.sql.*;

public class ConectorBBDD {
	
    Connection connection = null;
    String BD = "librosasucasa";
    String driverClassName = "com.mysql.jdbc.Driver";
    String driverUrl = "jdbc:mysql:///" + BD;
    String user = "root";
    String password = "1111";

    public ConectorBBDD() {
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(driverUrl, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra el driver");
        } catch (SQLException E) {
            System.out.println("Excepcion SQL: " + E.getMessage());
            System.out.println("Estado SQL: " + E.getSQLState());
            System.out.println("Codigo del Error: " + E.getErrorCode());
        } catch (Exception E) {
            System.out.println("Otro problema: " + E);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        try {
            connection.close();
            connection = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}