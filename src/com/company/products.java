package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class products {
    String Productname;
   int productid;
    String BrandName;
    int Price;
    int categoryid;
    Connection connection;


    public int getProductid() {
        return productid;
    }

    public products() {
    }

    public int setCategoryid(int categoryid) {
        this.categoryid = categoryid;
        return categoryid;
    }
    public String getProductname() {
        return Productname;
    }

    public String setProductname(String productname) {
        this.Productname = productname;
        return productname;
    }

    public int setProductid(int productid) {
        return productid;
    }

    public String getBrandName() {
        return BrandName;
    }

    public String setBrandName(String brandName) {
        this.BrandName = brandName;
        return brandName;
    }

    public int  getPrice() {
        return Price;
    }

    public int setPrice(int price) {
        return price;
    }

    public void addproduct()
{
    try {
        products prod=new products();
        connection con=new connection();
        connection=con.getConnection();
        if (connection != null){

            Scanner input=new Scanner(System.in);

          //user key in the inputs

            System.out.println("PRODUCT NAME");
            String productname= prod.setProductname(input.next());
            System.out.println("PRODUCT ID");
            int productid=prod.setProductid(input.nextInt());
            System.out.println("BRANDNAME");
            String brandname=prod.setBrandName(input.next());
            System.out.println("PRICE");
            int  price= prod.setPrice(input.nextInt());
            System.out.println("category  Id");
           int categoryid= prod.setCategoryid(input.nextInt());

           //used to insert data to the database
            PreparedStatement preparedstatement;

            //creating the sql statement
            String sql;
            sql="insert  into products (ProductName,ProductID,BrandName,Price,categoryid) VALUES ('"+productname+"','"+productid+"','"+brandname+"','"+price+"','"+categoryid+"')";
            preparedstatement=connection.prepareStatement(sql);

            preparedstatement.executeUpdate();
            System.out.println("DETAILS SUCCESSFULLY INSERTED TO THE DATABASE");
            // Register

            connection.close();
        }
    }
    catch (Exception e) {

        e.printStackTrace();
    }
}

}
