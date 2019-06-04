package com.company;

import java.io.File;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        String logFile = "/Users/Fhaelean/Desktop/access.log";
        File file = new File(logFile);
        Scanner scanner;

        CreateTable ct = new CreateTable();
        ct.createNewTable();

        InsertRecords app = new InsertRecords();

        try
        {
            scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                app.insert(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try {
            getRemHostRequsets();
            getUserActiv();
            getDataType();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private static void getRemHostRequsets() throws SQLException
    {
        String url = "jdbc:sqlite:/Users/Fhaelean/Desktop/log/lab1.db";
        Connection conn = DriverManager.getConnection(url);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(remHosts);

        TreeMap<Integer, String> hosts = new TreeMap<>();
        while (rs.next())
        {
            hosts.put(rs.getInt("amount"), rs.getString("remotehost"));
        }

        Set set = hosts.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry map = (Map.Entry)iterator.next();
            System.out.println("Remote host: " + map.getValue() + " request amount: " + map.getKey());
        }
    }

    private static void getUserActiv() throws SQLException
    {
        String url = "jdbc:sqlite:/Users/Fhaelean/Desktop/log/lab1.db";
        Connection conn = DriverManager.getConnection(url);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(userAct);

        TreeMap<Integer, String> users = new TreeMap<>();
        while (rs.next())
        {
            users.put(rs.getInt("amount"), rs.getString("username"));
        }

        Set set = users.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry map = (Map.Entry)iterator.next();
            System.out.println("User: " + map.getValue() + " entries: " + map.getKey());
        }
    }

    private static void getDataType() throws SQLException
    {
        String url = "jdbc:sqlite:/Users/Fhaelean/Desktop/log/lab1.db";
        Connection conn = DriverManager.getConnection(url);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(dataType);

        TreeMap<Integer, String> data = new TreeMap<>();
        while (rs.next())
        {
            data.put(rs.getInt("amount"), rs.getString("data_type"));
        }

        Set set = data.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry map = (Map.Entry)iterator.next();
            System.out.println("Data: " + map.getValue() + " entries: " + map.getKey());
        }
    }

    private static final String remHosts =
            "SELECT COUNT(*) amount,remotehost\n" +
            "FROM logData\n" +
            "GROUP BY remotehost\n" +
            "ORDER BY amount DESC\n" +
            "LIMIT 10 OFFSET 0";

    private static final String userAct =
            "SELECT COUNT(*) amount,username\n" +
            "FROM logData\n" +
            "GROUP BY username\n" +
            "ORDER BY amount DESC\n" +
            "LIMIT 10 OFFSET 0";

    private static final String dataType =
            "SELECT COUNT(*) amount,data_type\n" +
            "FROM logData\n" +
            "GROUP BY data_type\n" +
            "ORDER BY amount DESC\n" +
            "LIMIT 10 OFFSET 0";

}
