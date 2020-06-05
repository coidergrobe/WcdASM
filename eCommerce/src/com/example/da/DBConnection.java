package com.example.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(connection == null){
            // Tai driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Ket noi
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/t1808a1?serverTimezone=UTC","root","");
        }
        return connection;
    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        if(getConnection()!=null){
//            System.out.println("Succeed");
//        }
//    }
}
