package com.company.recursion;

public class ReverseStringRec {

    public static void main(String[] args) {
        String a = "hello";
        System.out.println("Reverse is "+revereString(a));
    }

    private static String revereString(String s) {
        int n = s.length();
        if(n <= 1) return s;
        return s.charAt(n - 1) + revereString(s.substring(0, n - 1));
    }

}
