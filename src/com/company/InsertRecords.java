package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecords {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/Users/Fhaelean/Desktop/log/lab1.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void insert(String time_in, String elapsed, String remotehost, String code_status, String bytes, String method, String url, String username, String peerstatus, String data_type) {
        String sql =
                "INSERT INTO logData(time_in, elapsed, remotehost, code_status, bytes, method, url, username, peerstatus, data_type) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, time_in);
            pstmt.setString(2, elapsed);
            pstmt.setString(3, remotehost);
            pstmt.setString(4, code_status);
            pstmt.setString(5, bytes);
            pstmt.setString(6, method);
            pstmt.setString(7, url);
            pstmt.setString(8, username);
            pstmt.setString(9, peerstatus);
            pstmt.setString(10, data_type);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}