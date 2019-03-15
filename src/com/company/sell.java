package com.company;
import java.sql.*;
import java.util.Date;
import java.util.Scanner;
public class sell {
    Scanner input = new Scanner(System.in);
    Scanner sc=new Scanner(System.in);
    double balance = 400;
    double bal;

    Connection conn;

    public sell() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String db = "jdbc:mysql://localhost:3306/Supermarket";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(db, username, password);
            doTests();
            //conn.close();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.err.println(ex.getMessage());
        } catch (InstantiationException ex) {
            System.err.println(ex.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void doTests() {
        // doSelectTest();

        //Delete();
        // doUpdateTest();
    }
    public void buy() {
        System.out.println("1.PRODUCTS(ENTER 1 TO DISPLAY THE PRODUCTS)\n ");
        Scanner input = new Scanner(System.in);

        int usersc = input.nextInt();
        int choices = usersc;

        switch (choices) {

            case 1:
                double[] money = {20.12, 32.12, 44.12, 56.12};//declaring an array

                // displaying first product
                for (int i = 0; i < money.length; i++)
                    System.out.println(money[0] + "\t" + "SUPERLOAF  \t");
                System.out.println(+money[1] + "\t" + "WHITEBREAD  \t");
                System.out.println(money[2] + "\t" + "FAMILY BREAD  \n");
                System.out.println(money[3] + "\t" + "BROWN BREAD  \t");

                //displaying the smallest price
                double min = money[0];

                for (int i = 0; i < money.length; i++) {
                    if (money[i] < min)
                        min = money[i];
                    //  System.out.println("THE MINIMUM PRICE FOR BREAD IS:" + min);

                    //second product
                    double[] soap = {40.0, 52.12, 64.12, 76.12};
                    for (int j = 0; j < money.length; j++)
                        System.out.println(soap[0] + "\t" + "KIBUYU  \t");
                    System.out.println(+soap[1] + "\t" + "MENENGAI  \t");
                    System.out.println(soap[2] + "\t" + "SUNLIGHT  \t");
                    System.out.println(soap[3] + "\t" + "BANDA  \t");

                    //displaying the smallest value of bread
                    double mn = soap[0];
                    for (int j = 0; j < money.length; j++) {
                        if (soap[j] < mn)
                            mn = money[j];

                        System.out.println("SELECT CHOICE FROM THE ABOVE PRODUCTS:");
                        double total = input.nextInt();
                        if (total < 400) {
                            //calculating the total cost after purchase
                            total = money[i] + soap[j];
                            bal = balance - total;
                            System.out.println("The Total cost is:" + total);
                            System.out.println("Your balance is:" + bal);

                            System.out.println("THE TRANSACTIONS DETAILS ARE SHOW BELOW FOR YOUR PURCHASES");
                            System.out.println("The Total cost is:" + total);
                            System.out.println("Your balance is:" + bal);
                            date();
                            break;
                        } else {
                            System.out.println("INSUFFICIENT FUNDS");
                        }
                        //   select();
                    }
                    break;
                }
                      break;
        }
    }

    //Method for date
    public void date() {
        // Instantiate a Date object
        Date date = new Date();

        // display time and date using toString()
        System.out.println(date.toString());
    }

    //display data from database
   private void select() {

        String query = "SELECT * FROM products";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String s = rs.getString("ProductName");
                String n = rs.getString("ProductID");
                String m = rs.getString("BrandName");
                String y = rs.getString("Price");
                String x = rs.getString("categoryid");
                //  System.out.println("PRODUCT NAME\t"+ "ProductID\t "+"BrandName\t" + "Price\t" + "Categoryid\t");//show table information
                System.out.println("ProductName:\t "+s + "ProductID:\t " + n + "BrandName:\t" + y + "Price:\t" + m + "CategoryID:\t" + x);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    // update data from database
    public void update() {
        //   System.out.print("\n[Performing UPDATE] ... ");
    select();
        try {

            System.out.println("Enter Product ID to Update");
            int productid=sc.nextInt();
            System.out.println("PRICE");
            int  price= sc.nextInt();
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE products SET PRICE='"+price+"' WHERE ProductID='"+productid+"'");
            System.out.println("updated price to "+price+" where Product id is "+productid+" sucessfully");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
 //
    //delete data from database

public void Delete() {
       // System.out.print("\n[Performing DELETE] ... ");
        try {

        System.out.println("Enter Product Id to delete");

        int productid=sc.nextInt();
        Statement st = conn.createStatement();
        st.executeUpdate("delete FROM products WHERE ProductId='"+productid+"'");
        System.out.println("deleted  Product id "+productid+" sucessfully");

    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    }
}



