package com.company.recursion;

import java.util.Random;

public class QuickSelect {
    public static void main(String[] args) {
        int[] arr = new int[]{5,61,4,7,2,99,1,56};
        int k = 8;
        System.out.println(k + "th smallest number is " + kthSmallest(arr,k,0,arr.length-1));
    }

    private static int kthSmallest(int[] arr, int k, int low, int high) {
        if(k > arr.length) return -1;
        if (high == low) {
            return arr[low];
        }
        int  pivotIdx = randomPartition(arr, low, high);
        if(pivotIdx == k - 1)
            return arr[pivotIdx];
        else if(pivotIdx > k - 1)
            return kthSmallest(arr, k, low, pivotIdx - 1);
        else
            return kthSmallest(arr, k, pivotIdx + 1, high);
    }


    private static int randomPartition(int[] arr, int low, int high) {
        Random r = new Random();
        int pivotIdx = low + r.nextInt(high-low);

        int pivotElem = arr[pivotIdx];
        // Replace high with partition Idx
        int temp =  arr[high];
        arr[high]= arr[pivotIdx];
        arr[pivotIdx] = temp;

        int i = low, j = high - 1;
        while (i<= j){
            while (arr[i] < pivotElem)
                i++;
            while (j>=0 && arr[j] >= pivotElem)
                j--;
            if(i > j)
                break;

            temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        if(i > j){
            temp = arr[i];
            arr[i] = arr[high];
            arr[high] = temp;
        }
        return i;
    }
}
