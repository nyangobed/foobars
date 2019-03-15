
package com.company;
import com.mysql.jdbc.ResultSetMetaData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class register {

    String firstname;
    String lastname;
    int id;
    String dateofbirth;
    int nationalid;
    Connection connection;

    public register()
    {}

    public String getFirstname() {
        return firstname;
    }

    public String setFirstname(String firstname) {
        this.firstname = firstname;
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String setLastname(String lastname) {
        this.lastname = lastname;
        return lastname;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public String setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
        return dateofbirth;
    }

    public int getNationalid() {
        return nationalid;
    }

    public int setNationalid(int nationalid) {
        this.nationalid = nationalid;
        return nationalid;
    }
public void addSupermarketAttendant()
{
    try {
        register reg=new register();
        connection con=new connection();
        connection=con.getConnection();
        if (connection != null){
            Scanner input=new Scanner(System.in);
//user key in the inputs
            System.out.println("ENTER FIRST NAME");
            String firstname= reg.setFirstname(input.next());
            System.out.println("ENTER LAST NAME");
            String lastname=reg.setLastname(input.next());
            System.out.println("ENTER NATIONAL ID NUMBER");
            int id=reg.setNationalid (input.nextInt());
            System.out.println("ENTER INTER ID");
            int idd= reg.setId(input.nextInt());

           //used to insert data to the database

            PreparedStatement preparedstatement;

            //creating the sql statement
            String sql="insert  into SupermarketAttendant (Firstname,Lastname,AttendantId,NationalID) VALUES ('"+firstname+"','"+lastname+"','"+id+"','"+idd+"')";

            preparedstatement=connection.prepareStatement(sql);

            preparedstatement.executeUpdate();

            System.out.println("DETAILS SUCCESSFULLY INSERTED TO THE DATABASE");


            // data from database


            connection.close();

        }

    } catch (Exception e) {

        e.printStackTrace();
    }
}
}
