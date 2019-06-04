package com.company;

import java.io.File;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String logFile = "/Users/Fhaelean/Desktop/access.log";
        File file = new File(logFile);
        Scanner scanner;

        CreateTable ct = new CreateTable();
        ct.createNewTable();

        InsertRecords app = new InsertRecords();

        try {
            scanner = new Scanner(file);
            int i = 0;
            while (/*scanner.hasNextLine()*/ i < 30)//TODO
            {
                app.insert(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next());
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
