package com.company.recursion.tail;

public class Factorial {

    static int fact(int n) {
        if (n == 0) return 1;
        return n * fact(n-1);
    }

    static int tailFact(int n, int fact) {
        if (n == 0) return fact;
        fact *= n; // not returning result
        return tailFact(n-1, fact);
    }

    // Driver program
    public static void main(String[] args)
    {
        int n = 40;
        long start = System.nanoTime();
        fact(n);
        long end = System.nanoTime();

        System.out.println("1 time :" + (end - start));

        // ===========================================
        start = System.nanoTime();
        int fact = 1;
        tailFact(n, fact);
//        System.out.println("2 fact :" + tailFact(n, fact));
        end = System.nanoTime();

        System.out.println("2 time :" + (end - start));
    }
}
