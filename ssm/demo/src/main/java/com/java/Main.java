package com.java;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int ge = 0,shi,bai = 0;
        for(int x=10;x<=999;x++) {
//            tt=x;
                ge=x%10;
//               shi=x/10%10;
                bai=x/100%10;
//			System.out.print(num2);
            if(ge==bai) {
                System.out.println(x);
            }
        }
    }

}