package com.company.recursion;

public class PowerWithRecursion {
    public static void main(String[] args) {
        int num = 2;
        int power = 5;
//        System.out.println("power(num, power) "+ powerRecursion(num, power));
        System.out.println("power("+num+", "+power+") "+ powerDivideNConq(num, power));
    }

    private static int powerDivideNConq(int num, int power) {
        // logarithmic
        // Even N : X ^ N = [X ^ (2)] ^ FLOOR(N/2)
        // Odd N : X ^ N = X . [X ^ (2)] ^ FLOOR(N/2)
        // Remember not to do : [FLOOR(N/2) + 1] as this + 1 will
        // go in recursion and change entire flow

        //  when we do n/2, it will not give correct for integer data type
        // n/2 + 1 is the required power
        if(power == 0) return 1;
        if(power == 1) return num;
        if(power %2 == 0)
            return powerDivideNConq(num * num, power/2);
        else
            return num * powerDivideNConq(num * num, power/2) ;
    }

    private static int powerRecursion(int num, int power) {
        // linear
        if(power == 0) return 1;
        if(power == 1) return num;
        return num * powerRecursion(num, power - 1);
    }
}
