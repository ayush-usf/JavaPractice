package com.company.recursion;

import java.util.Arrays;

public class ThreeWayPartitioning {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        int pivot1 =  14;
        int pivot2 =  20;
        System.out.println(Arrays.toString(arr));
        int pivot2Idx = partitionArray(arr, 0, arr.length -1,pivot2);
        System.out.println(Arrays.toString(arr));
        System.out.println("pivot2Idx = " + pivot2Idx);
        int pivotIdx = partitionArray(arr, 0, pivot2Idx -1,pivot1);
        System.out.println(Arrays.toString(arr));
        System.out.println("pivotIdx = " + pivotIdx);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int partitionArray(int[] arr, int low, int high, int pivotElem) {
        int pivIdx = low;

        // Geting the location of pivot Element
        for(int i = low + 1; i < high; i++){
            if(arr[i] == pivotElem){
                pivIdx = i;
                break;
            }
        }
        int temp = arr[high];
        arr[high] = arr[pivIdx];
        arr[pivIdx] = temp;

        int i = low;
        int j = high - 1;
        while (i<=j){
            while (arr[i] <= pivotElem)
                i++;
            while (j>= low && arr[j] > pivotElem)
                j--;
            if(i>j)
                break;
            // Swap i with j
            temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        if(i > j){
            temp = arr[high];
            arr[high] = arr[i];
            arr[i] = temp;
        }
        return i;
    }
}
