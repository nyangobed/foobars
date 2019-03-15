package com.company;

public class SuperMarketSeller {


    public static void main(String[] args) {
        getChange();
    }


    public static String getChange() {

        //initi
        String change = null;
        float cash = 400;
        float unitprice = 1;
        int totalitems = 0;


        for (unitprice = 1; unitprice <= cash; totalitems++) {
            cash -= unitprice;

            unitprice *= 1.2;
            System.out.print("bought Item " + totalitems + " for: " + unitprice + "/=, I have this balance:" + cash + "/= \n");

        }
        System.out.print("Total Change : " + cash + "/= \n");
        System.out.print("Amount Spend : " + (400 - cash) + "/= \n");
        System.out.print("Total number of items : " + totalitems + "/= \n");

        return change;

    }
}