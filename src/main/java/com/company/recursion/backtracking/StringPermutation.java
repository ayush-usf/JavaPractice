package com.company.recursion.backtracking;

import java.util.Arrays;

public class StringPermutation {

    // O(n * n!) Time Complexity
    public static void main(String[] args) {
        String str = "aab";
        printPermuations(str);
    }

    private static void printPermuations(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        str = String.valueOf(charArr);
        printPermuations(str, 0 ,str.length() - 1);
    }

    private static void printPermuations(String str, int low, int high) {
        if(low == high){
            System.out.println(str);
            return;
        }
        for(int i = low; i <= high; i++){
            str = swap(str, i, low);
            printPermuations(str, low  + 1, high);
            str = swap(str, i, low);
            while (i < high && str.charAt(i) == str.charAt(i + 1))
                i++;
        }
    }

    private static String swap(String str, int i, int j) {
        char[] charArr = str.toCharArray();
        char temp = charArr[i];
        charArr[i] =  charArr[j];
        charArr[j] = temp;
        return String.valueOf(charArr);
    }
}


//    private static void printPermuations(String str) {
//        permute(str,0, str.length()-1);
//    }
//    private static void permute(String str, int low, int high) {
//        // Goal of recursion / base case
//        if(low == high) {
//            System.out.println(str);
//            return;
//        }
//        // For inner recursive calls, low = low + 1, low + 2 ...
//        // So, the for loop not always starts with i = low
//        for(int i = low; i <= high; i++){
//            str = swap(str,low,i);
//            System.out.println("String till '"+ str.substring(0, low + 1) + "' is fixed");
//            permute(str,low+1, high);
//            str = swap(str,low,i);
//
//        }
//    }

//    private static String swap(String str, int low, int high) {
//        char[] chars = str.toCharArray();
//        char temp = chars[low];
//        chars[low] = chars[high];
//        chars[high] = temp;
//        return String.valueOf(chars);
//    }
