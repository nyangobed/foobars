package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        register register = new register();
        products prod=new products();
        Connection conn=null;

        sell sell=new sell();
       products products= new products();


        System.out.println("Select from the menu\n 1. Create New Supermarket Attendant \n 2. Add a new product \n 3.Sell Products\n4.Delete\n5.Update");

        Scanner input = new Scanner(System.in);
        int  one=1 ;
        int two=2;
        int three=3;
        int four=4;
        int five=5;
        int userinput=input.nextInt();
        int choices=userinput;
        switch (choices){
            case 1:
                register.addSupermarketAttendant();
                break;
            case 2:
               products.addproduct();
                break;

            case 3:
            sell.buy();
                break;
            case 4:
                sell.Delete();

                break;
            case 5:
                sell.update();

                break;


        }



    }


}
