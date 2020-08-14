package com.pakage;

import java.sql.Array;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /*byte a = 0;

       // System.out.println(a);
        Date today = new Date();
        System.out.print(today);
        //String name ="   manish patil  // ";
        String sirname = "patil";
        String a = name.replace("/","@");
        System.out.println(a);
        //
         *
        int[] a = new int[10];
        a[1] =100;
        a[3]=2;
        a[9] =2;
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        *
        String a="123";
       int ai = Integer.parseInt(a);
        System.out.println(ai);

         */
        System.out.print("enter the principal cost ::");
        Scanner scanner = new Scanner(System.in);
        int princ = scanner.nextInt();
        System.out.print("\nenter the rate of interest::");
         double rate = scanner.nextDouble()/100/12;
        System.out.print("\nenter the number of years of payment::");
        int months = scanner.nextInt()*12;
        NumberFormat morgage = NumberFormat.getCurrencyInstance();
        double morg = princ *((rate*Math.pow((1+rate),months))/(Math.pow((1+rate),months)-1));
        String morge = morgage.format(morg);
        System.out.print("the mortgage per month =" + morge);
    }
}
