package com.company.recursion;

public class DecToBinaryString {
    // 16
    // 1 0 0 0

    static String convertDigitalToBinary(int n, String s){

        int rem = n % 2;

        if(n == 0){
            return rem + s;
        }
        n = n/2;
        // Bottom up
//        n 5 | rem 0 | s
//        n 2 | rem 1 | s 0
//        n 1 | rem 0 | s 10
//        n 0 | rem 1 | s 010
//        1010
//        System.out.println("n "+n + " | "+"rem "+rem+ " | "+"s "+s);
//        return convertDigitalToBinary(n,rem +s);

//        n 0 | rem 1 | s2 1
//        n 1 | rem 0 | s2 10
//        n 2 | rem 1 | s2 101
//        n 5 | rem 0 | s2 1010
//        1010

//        String s2 =
        return convertDigitalToBinary(n,rem + s);
//        System.out.println("n "+n + " | "+"rem "+rem+ " | "+"s2 "+s2);
//        return s2;
    }

    public static void main(String[] args) {
        System.out.println(convertDigitalToBinary(10, ""));
    }
}
