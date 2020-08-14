package com.manish.practice;

import java.util.*;

public class Calculator {
    Scanner sc;

    public Calculator(Scanner scanner) {
        this.sc = scanner;
    }

    /**
     *
     * @return it results output of calc
     */
    public float simpleCal() {
        float a = 0, b = 0;
        char opt;
        float ans = 0;
        System.out.println("enter two numbers and then choose arithmetic operation");
        a = sc.nextFloat();
        System.out.println("a=" + a);
        b = sc.nextFloat();
        System.out.println("b=" + b);
        System.out.println("now choose arithmetic operation as sign");
        opt = sc.next().charAt(0);
        switch (opt) {
            case '+': {
                ans = a + b;
                break;
            }
            case '-': {
                ans = a - b;
                break;
            }
            case '*': {
                ans = a * b;
                break;
            }
            case '/': {
                try {
                    ans = a / b;
                    System.out.println("a/b");
                }catch(Exception exception){
                    exception.printStackTrace();
                    System.out.println("Exception");
                }

                break;
            }
            default:
                System.out.println("not a  valid entry");

        }

        return ans;

    }


    public float interestCal() {
        Scanner sc = new Scanner(System.in);
        float a = 0, p = 0, t = 0, n = 0;
        char opt;
        float r;
        System.out.println("enter principle amount");
        p = sc.nextInt();
        System.out.println("enter rate");
        r = sc.nextFloat();
        System.out.println("enter period in months");
        t = sc.nextInt();
        System.out.println("choose the type of interest (S/C)");
        opt = sc.next().charAt(0);
        if (opt == 'S') {
            a = (p + p * r * t);
        } else if (opt == 'C') {
            System.out.println("enter number of installments");
            n = sc.nextInt();
            float v = (1 + r / n);
            a = p * v * n * t;
        } else {
            System.out.println("invalid entry");
        }

        return a;
    }

    /**
     * This is a main method developed by mainsh
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator(sc);
        System.out.println("what would you like to do?  A.] simple calculator B.] interest calculator");
        if (sc.next().charAt(0) == 'A')
            System.out.println(calculator.simpleCal());
        else
            System.out.println(calculator.interestCal());

    }
}
