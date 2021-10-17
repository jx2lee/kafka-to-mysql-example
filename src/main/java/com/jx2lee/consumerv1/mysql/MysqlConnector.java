package com.jx2lee.consumerv1.mysql;

import java.sql.*;
import java.util.Properties;

public class MysqlConnector {
    static final String DB_URL = "jdbc:mysql://localhost:3306/kabank?serverTimezone=UTC&useSSL=false";
    static final String USERNAME = "test";
    static final String PASSWORD = "1234";
    static Connection mysqlConnection = null;
    public void connect() {

        Statement stmt = null;
        try {
            Properties configs = new Properties();
            configs.put("USER", USERNAME);
            configs.put("PASSWORD", PASSWORD);

            mysqlConnection = DriverManager.getConnection(DB_URL, configs);
            System.out.println("MysqlConnector.connect");
            stmt = mysqlConnection.createStatement();

            String sql;
            sql = "SELECT * FROM acco";
            ResultSet rs = stmt.executeQuery(sql);

            // while(rs.next()){
            //     String acno = rs.getString("acno");
            //     String cstno = rs.getString("cstno");
            //
            //     System.out.println("acno = " + acno);
            //     System.out.println("cstno = " + cstno);
            // }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect () {
        try {
            mysqlConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("MysqlConnector.disconnect");
    }

    public void save () {

    }
}
