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
                + " time_in text NOT NULL,\n"
                + " elapsed text NOT NULL,\n"
                + " remotehost text NOT NULL,\n"
                + " code_status text NOT NULL,\n"
                + " bytes text NOT NULL,\n"
                + " method text NOT NULL,\n"
                + " url text NOT NULL,\n"
                + " username text NOT NULL,\n"
                + " peerstatus text NOT NULL,\n"
                + " data_type text NOT NULL \n"
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