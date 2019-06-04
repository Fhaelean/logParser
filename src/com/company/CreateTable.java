package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:/Users/Fhaelean/Desktop/log/lab1.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS logData (\n"
                + " time_in text,\n"
                + " elapsed text,\n"
                + " remotehost text,\n"
                + " code_status text,\n"
                + " bytes text,\n"
                + " method text,\n"
                + " url text,\n"
                + " username text,\n"
                + " peerstatus text,\n"
                + " data_type text \n"
                + ");";
        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}