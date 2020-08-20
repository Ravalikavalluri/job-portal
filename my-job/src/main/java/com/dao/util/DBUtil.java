package com.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn != null) //if there is a connection already return it, otherwise establish one
            return conn;
        else {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!");
            } catch (ClassNotFoundException e) {
                System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
                e.printStackTrace();
            }

            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal?useSSL=false&serverTimezone=UTC", "root", "root");

                if (conn != null) {
                    System.out.println("Connection Successful! Enjoy. Now it's time to push data");
                } else {
                    System.out.println("Failed to make connection!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }

    }
}