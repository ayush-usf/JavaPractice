package com.company.recursion.backtracking;

public class StringPermutation {

    private static void printPermuations(String str) {
        permute(str,0, str.length()-1);
    }
    private static void permute(String str, int low, int high) {
        // Goal of recursion / base case
        if(low == high) {
            System.out.println(str);
            return;
        }
        // For inner recursive calls, low = low + 1, low + 2 ...
        // So, the for loop not always starts with i = low
        for(int i = low; i <= high; i++){
            str = swap(str,low,i);
            System.out.println("String till '"+ str.substring(0, low + 1) + "' is fixed");
            permute(str,low+1, high);
//            str = swap(str,low,i);

        }
    }

    private static String swap(String str, int low, int high) {
        char[] chars = str.toCharArray();
        char temp = chars[low];
        chars[low] = chars[high];
        chars[high] = temp;
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
//        String str = "aca";
        String str = "abc";
        // O(n * n!) Time Complexity
        printPermuations(str);
    }
}
