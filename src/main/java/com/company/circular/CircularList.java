package com.company.circular;

import java.util.*;

public class CircularList {
    static long sumProfit(int k, List<Integer> profit){
        if(profit.size() == 0) return 0;
        int n = profit.size();
        if(k == n/2) return profit.stream().mapToLong(a -> a).sum();

        // k must be greater
        if (n < k)
        {
            System.out.println("Invalid");
            return 0;
        }

        int sum = 0, start = 0, end = k - 1;

        // calculate the sum of first k elements.
        for (int i = 0; i < k; i++)
            sum += profit.get(i);

        int ans = sum;

        for (int i = k; i < n + k; i++)
        {

            // add current element to sum
            // and subtract the first element
            // of the previous window.
            sum += profit.get(i % n) - profit.get((i - k) % n);
            sum += profit.get((i +n/2) % n) - profit.get(((i +n/2) - k) % n);

            if (sum > ans)
            {
                ans = sum;
                start = (i - k + 1) % n;
                end = i % n;
            }
        }

        System.out.println("max circular sum = " + ans);
        System.out.println("start index = " + start + "\nend index = " + end);
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        int k = 10;
        System.out.println(Arrays.toString(arr));
        rotateArray(arr,k);
        System.out.println(Arrays.toString(arr));

//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,5,1,3,7,-3));
//        System.out.println("ArrayList : " + list);
//        Collections.rotate(list,1);
//        System.out.println("ArrayList Rotated: " + list);
//        System.out.println(sumProfit(2,list));

    }

    private static void rotateArray(int[] arr, int rotations) {
        for(int i = 0; i < rotations; i++){
            rotateArrayOnceLeft(arr);
            System.out.println("After Left 1 Rotations : at "+ (i +1) +"th time " +Arrays.toString(arr));
            int k = 2;
            rotateArrayKTimesLeft(arr,k);
            System.out.println("After Left : " + (k) + " Rotations : "+Arrays.toString(arr));

//            rotateArrayOnceRight(arr);
//            System.out.println("After Right" + (i +1) + " Rotations : "+Arrays.toString(arr));
//            int k = 2;
//            rotateArrayKTimesRight(arr,k);
//            System.out.println("After Right" + (k) + " Rotations : "+Arrays.toString(arr));
        }
    }

    // Move ith element to (i + 1)th position right
    static void rotateArrayOnceRight(int[] arr) {
        int n = arr.length;
        int last = arr[n-1]; // as k = 1

        // Moving ith element to (i + 1)th position
        for(int i = n - 2; i>=0 ; i--){
            arr[i + 1] = arr[i];
        }
        arr[0] = last;
        // Space Complexity: Theta(1)
        // Time Complexity: Theta(n) | n-1 ~ n
    }

    // Move ith element to (i + k)th position right
    static void rotateArrayKTimesRight(int[] arr, int k) {
        int n = arr.length;
        int[] temp = Arrays.copyOfRange(arr, n-k, n);

        // Moving ith element to (i + k)th position
        // Right shift by k positions

        for(int i = (n - 1) - k; i>=0 ; i--){
            arr[i + k] = arr[i];
        }
        // Adding last k elements to the starting
        for(int i = 0; i < k; i++){
            arr[i] = temp[i];
        }
        // Space Complexity: Theta(k)
        // Time Complexity: Theta(n) if k = 1 | n-1 ~ n
    }

    // Left
    // Move (i + 1)th element to ith position left
     static void rotateArrayOnceLeft(int[] arr) {
        int n = arr.length;
        int first = arr[0];
        for(int i = 0; i < n - 1 ; i++){
            arr[i] = arr[i+1];
        }
        arr[n-1] = first;
    }

    // LEFT k times
    // Move ith element to (i - 1k)th position left
     static void rotateArrayKTimesLeft(int[] arr, int k) {
         int n = arr.length;
        // kth elem ~ (k - 1)th index
        int[] temp = Arrays.copyOfRange(arr, 0, k);
        for(int i = 0; i < n - k ; i++)
            arr[i] = arr[i + k];

        // Copy from (n - k) till (n-1) [high]
        for(int i = 0; i < k; i++)
            arr[i + (n - k)] = temp[i];
    }
}
