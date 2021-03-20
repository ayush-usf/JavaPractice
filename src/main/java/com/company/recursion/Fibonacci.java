package com.company.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fibonacci(n));
        // 0 1 1 2
    }

    private static int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        return fibonacci(n-1) + fibonacci( n  - 2);
    }
}
