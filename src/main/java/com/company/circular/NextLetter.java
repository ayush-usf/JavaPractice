package com.company.circular;

public class NextLetter {

    public static void main(String[] args) {
        char[] arr = new char[]{'a', 'c', 'f', 'h'};
        char key = 'f';
//        char key = 'b';
//        char key = 'g';
//        char key = 'm';
//        char key = 'h';
        System.out.println(getNextLetter(arr, key));
    }

    public static char getNextLetter(char[] arr, char key) {
        if(key < arr[0] || key > arr[arr.length - 1])
            return arr[0];

        // 'a', 'c', 'f', 'h'
        int low = 0, high =  arr.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(key < arr[mid]){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return arr[low % arr.length];
    }
}
