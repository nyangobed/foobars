package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.*;

public class connection {

    public Connection getConnection() {

        Connection connection=null;

        try {
            String db="jdbc:mysql://localhost:3306/supermarket";
            String username="root";
            String password="";
            forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(db,username,password);

        }
        catch (Exception e){
            e.printStackTrace();

        }
        return connection;
    }
}