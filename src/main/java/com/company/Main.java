package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int num = 0;
//        System.out.println(returnIdx(new int[]{1,3,8, 10},10));
//        System.out.println(returnIdx(new int[]{1, 2, 4, 5, 6, 7},5));
//        System.out.println(returnIdx(new int[]{10,9,8,7,4,2},4));
//        System.out.println(Arrays.toString(merge(new int[]{1,3,5},new int[]{2,6,8})));
//        System.out.println(Arrays.toString(merge2Arrays(new int[]{1, 3, 5}, new int[]{2, 6, 8})));
//        System.out.println(Arrays.toString(merge(new int[]{1, 3, 5, 2, 6, 8},0,5)));
//        int[] arr = new int[]{1, 3, 5, 2, 7, 9, 5,7,8, 11, 12};
        //        mergeSort(arr);

//        int[] arr = new int[]{1, 10, 12, 11, 6, 4, 3, 5, 2, 5, 7};
//        int[] arrDesc = new int[]{110, 100 ,99, 76, 54, 43, 23, 19, 1};
//        System.out.println(binarySearchDesc(arrDesc, 0, 0, arrDesc.length -1));

//        int[] arrAsc = new int[]{1, 4, 5, 7, 9 ,12, 44, 65};
//        int[] arrAsc = new int[]{4, 6, 10};
//        System.out.println(binarySearchIteration(arrAsc, -1, 0, arrAsc.length -1));

//        int[] arr = new int[]{8, 3, 5, 2, 7, 9,4, 11 ,1};
//        int pivotIdx = partitionMid(arr, 0 , arr.length - 1);
//        System.out.println("Returned adjusted pivotIdx = " + pivotIdx);
//        quickSort(arr);

//        System.out.println("arr[pivotIdx] = " + arr[pivotIdx]);


//        System.out.println(Arrays.toString(insertionSort(new int[]{4,2,3,1})));
//        String[] chars = new String[]{"A","B","A","B","A","A","B"};
//        sortAB(chars);
//        String[] chars = new String[]{"A","B","C","A","B","C","A","A","B"};
//        sortABC(chars);
//        System.out.println(Arrays.toString(chars));

        int[] arr = new int[]{823, 325, 569, 819, 713, 126};
//        modifCountingSortStable(arr, 8);
        radixSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    // Remember: (arr[i] / place) % 10
    public static void radixSort(int[] arr) {

        if (arr == null || arr.length == 0) 	return;

	/*  First, compute the number of digits in each element
    	We assume they all have the same # of digits,
    	So, taking # of digits of the first element  */

        // Getting # of digits using log 10
        // log 100 = (2) and + 1 = 3, so 3 digits

        int ndigits = (int) ( Math.log10( arr[0] ) + 1); // Floor

        int[] B = new int[arr.length];

        // Counter array
        int[] count = new int[10];

        int place = 1;
        int digitCnt = 0;

        while ( digitCnt < ndigits) {

            Arrays.fill(count, 0);	// reset counter array

            // Counting Sort
            for (int i = 0; i < arr.length; i++) {

                // Getting the digit at unit / tens / hund... place
                // 123 / 10 = 12 | 12 % 10 = 2 ; divide by position and mod by 10

                int digitVal = (arr[i] / place) % 10;

                count[digitVal]++;
            }

            for (int i = 1; i < 10; i++)	count[i] += count[i - 1];

            for (int i = arr.length - 1; i >= 0; i--){
                count[(arr[i] / place) % 10]--;

                // B [C [A]]
                B[ count[ (arr[i] / place) % 10 ]] = arr[i];
            }

            // copy the temp result back into arr,
            // based on place-wise sorted order

            for (int j = 0; j < arr.length; j++)	arr[j] = B[j];

            place = place * 10;
            digitCnt++;
        }
    }



    private static void modifCountingSortStable(int[] arr, int maxVal) {
        int[] counter = new int[maxVal + 1];
        int[] B = new int[arr.length];
        for (int val : arr) {
            counter[val]++;
        }
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            counter[arr[i]]--;
            B[counter[arr[i]]] = arr[i];
        }
        // copy the result back into arr
        for (int j = 0; j < arr.length; j++)
            arr[j] = B[j];
    }

    private static int[] countingSort(int[] arr, int maxVal) {
        int[] counter = new int[maxVal + 1];
        int[] B = new int[arr.length];
        for(int val : arr){
            counter[val]++;
        }
        for(int i = 1; i < counter.length; i++){
            counter[i] += counter[i-1];
        }
        for(int i = 0; i < arr.length ; i++){
            B[counter[arr[i]] - 1] = arr[i];
        }
        return B;
    }

    public static void sortABC(String[] letters){
        int idx = sortABCHelper(letters, 0, letters.length - 1);
        sortAB(letters, idx);
    }

    private  static  int sortABCHelper(String[] letters, int low, int high) {
        int i = 0;
        int j = high;

        while (i < j){
            while(i < j && (letters[i].equals("A") || letters[i].equals("B")))
                i++;
            while(i < j && letters[j].equals("C"))
                j--;
            if(i < j){
                letters[i++] = letters[j];
                letters[j--] = "C";
            }
        }
        return j;
    }

    public static void sortAB(String[] letters, int high){
        int i = 0;
//        int j = letters.length -1;
        int j = high;
        while (i < j){
            // For all 'A's
            // Also, we have to stop at B
            // Also, i could be equal to j
            while(i < j && letters[i].equals("A"))
                i++;
            while(i < j && letters[j].equals("B"))
                j--;
            if(i < j) {
                letters[i++] = "A";
                letters[j--] = "B";
            }
        }
    }

    private static int binarySearchIteration(int[] arr, int target, int low, int high) {
        if(target > arr[high])
            return -1;
        while (low<=high){
            if(low == high && arr[low] != target){

                return low;
            }
            int mid = low + (high - low)/2;
            if(arr[mid] == target)
                return mid;
            if(target < arr[mid]){
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high){
            int pivotIdx = partitionMid(arr, low, high);
            quickSort(arr, low, pivotIdx -1);
            quickSort(arr, pivotIdx + 1, high);
        }
    }

    public static int partitionMid(int arr[], int low, int high) {
        int mid = low + (high - low)/2;
        int pivotElem = arr[mid];

        // Swap pivot with elem at idx high
        int temp = arr[high];
        arr[high] = arr[mid];
        arr[mid] = temp;

        int i = low;
        int j = high - 1;
        while (i <=j){
            while (arr[i] < pivotElem)
                i++;
            while (j >= low && arr[j] >= pivotElem)
                j--;
            if(i > j)
                break;
            // Swapping i and j. Increment i, decrement j
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

//    public static int partitionMid(int arr[], int low, int high) {
//        int mid = low + (high -low)/2;
//        int pivotElem = arr[mid];
//
//        // Replace pivot with element at last index
//        int temp = arr[high];
//        arr[high] = arr[mid];
//        arr[mid] = temp;
//
//        int i = low;
//        int j = high - 1;
//
//        while (i<=j){
//            // Pivot Elem is placed at the last
//            // Even if i reaches the high -1
//            // if will be restricted to high
//            // as pivot already at the last position.
//            while (arr[i] < pivotElem){
//                i++;
//            }
//            // If the list is reverse sorted
//            // 10,8,7,6
//            // j will go till low/ i
//            while (j >= low && arr[j] >= pivotElem){
//                j--;
//            }
//            if(i > j)
//                break;
//            else{
//                // Replace i with j
//                temp = arr[j];
//                arr[j] = arr[i];
//                arr[i] = temp;
//            }
//        } // while
//
//        if(i >j){
//            // Swap arr[high] (pivotElem)
//            // with arr[i] place
//            temp = arr[i];
//            arr[i] = pivotElem;
//            arr[high] = temp;
//        }
//        return pivotElem;
//    }

    /**
     * Helper method for the quick sort. Rearranges the array so that it
     * first has elements < pivot, then pivot, and then elements >= pivot.
     * Chooses the middle element as the pivot.
     * @param arr array
     * @param low index of the first element of the sub-array
     * @param high index of the last element of the sub-array
     * @return index of the pivot after partition
     */
    public static int partitionOlga(int arr[], int low, int high) {
        int mid = (low + high) / 2;
        int pivotElem = arr[mid];

        // Swap pivot with the element at the last index
        int tmp = arr[high];
        arr[high] = pivotElem;
        arr[mid] = tmp;

        int i = low;
        int j = high - 1;
        while (i <= j) {
            while ( (arr[i] < pivotElem))
                i++;

            while ((j >= low) && (arr[j] >= pivotElem))
                j--;

            if (i > j)
                break;
            else { // swap elements at indices i and j. Increment i, decrement j
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        } // while
        if (i > j) {
            // swap arr[i] and last elem
            tmp = arr[i];
            arr[i] = arr[high];
            arr[high] = tmp;
        }
        return i;
    }

    static int partition1(int[] arr, int low, int high){
        // high is inclusive
        // return the position of the partition
        int mid = (low + high)/2;
        int pivElem =  arr[mid];
        int last = high;

        // swapping the pivot with last element
        int temp = arr[high];
        arr[high] = pivElem;
        arr[mid] = temp;

        while (low < high){
            // arr[high] is the new pivot element
            while(low < high && arr[low] < pivElem)
                low++;
            while(low < high && arr[high] >= pivElem)
                high--;

            if(low < high) {
                temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        // swap pivot back to the ith position
        if(low < high) {
            temp = arr[low];
            arr[low] = pivElem;
            arr[last] = temp;
        }

        return low;
    }


    public static int binarySearchDesc(int[] arr, int target, int low, int high){
        if(low == high && arr[low] != target)
            return -1;
        int mid = low + (high - low) / 2;
        if(arr[mid] == target)
            return mid;
        if(target > arr[mid])
            return binarySearchDesc(arr,target, low, mid);
        else
            return binarySearchDesc(arr, target, mid + 1, high);
    }

    private static void mergeSort(int[] arr) {
        int[] res = new int[arr.length];
        mergeSort(arr, res, 0,arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int low, int high) {
        // base case
        // When low = mid + 1, will become
        // greater than high
        if(low >= high){
            return ;
        }
        int mid = low + (high - low) / 2;
        mergeSort(arr, temp, low, mid);
        mergeSort(arr, temp, mid + 1, high);
        // reached leaf node
        merge(arr, temp, low, high);
    }


    // 1,3,5 | 2,6,8
    // 1 2


    // We don't have high of sub-array 1
    // and low of of sub-array 2, as that
    // will be calculated using mid
    static void merge(int[] arr, int[] temp, int low, int high){

        int mid= low + (high - low)/2;

        // IMPORTANT: positions of i=k,j
        int i = low;
        int j = mid+1;
        int k = low;

        // coz high = length - 1
        while(k <= high){
            // If array 1 ended, take remainging
            // elements of second array.
            if(i > mid){
                temp[k]= arr[j];
                j++;
            }
            else if(j > high){
                temp[k]= arr[i];
                i++;
            }
            // Main Case
            else if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // copy the result from temp back to arr
        for (k = low; k <= high; k++)
            arr[k] = temp[k];
    }

    static int[] merge2Arrays(int[] arr1, int[] arr2){
        int[] res = new int[arr1.length+arr2.length];
        int i =0, j = 0, k = 0;
        while (i <arr1.length && j < arr2.length){
            if(arr1[i]<=arr2[j]){
                res[k] = arr1[i];
                i++;
            }
            else{
                res[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i <arr1.length){
            res[k++] = arr1[i++];
        }
        while (j <arr2.length){
            res[k++] = arr2[j++];
        }
        return res;
    }
    // 4 | 3 1
// 3 4 | 1
    static int[]  insertionSort(int[] arr ) {
        if(arr == null) return new int[0];
        int curr;
        int j;
        for(int i = 1; i< arr.length; i++){
            curr = arr[i]; // so curr elem is 1 after the sorted array, where unsorted array starts
            j = i - 1; // j is 1 before the unsorted array, last element of the sorted array


            while (j > -1 && curr < arr[j]) { // first unsorted element < large sorted number
                // Stops when finds a smaller number position

                // Shifting all numbers larger than curr to right, expanding len of sorted array
                arr[j+1] = arr[j];
                j--;
            }
            // If curr > arr[j], will not go in while, it is larger than the sorted list
            arr[j+1]= curr;
        }
        return arr;
    }




    // Leetcode
    static int returnIdx(int[] arr, int k){
        int low = 0;
        int high = arr.length -1;
        int sortOrder = 1;
        if(arr[0] > arr[1])
            sortOrder = 0;
        return recursiveSearch(low, high, arr, k, sortOrder);
    }
    // Leetcode Question
    private static int recursiveSearch(int low, int high, int[] arr, int k, int sortOrder) {
        int mid = low + (high - low)/2;
        if(arr[mid] == k)   return mid;
        if(sortOrder == 1){
            if(k < arr[mid])
                return recursiveSearch(low,mid, arr, k, sortOrder);
            else
                return recursiveSearch(mid+1,high, arr, k, sortOrder);
        }
        else{
            if(k > arr[mid])
                return recursiveSearch(low,mid, arr, k, sortOrder);
            else
                return recursiveSearch(mid+1,high, arr, k, sortOrder);
        }
    }

    public static int factorial(int number){
        int fact = 1;
        for(int i=1;i<=number;i++){
            fact=fact*i;
        }
        return fact;
    }
    public  static  int ncr(int n, int r){
        return (factorial(n)/(factorial(n-r) * factorial(r)));
    }


}

//count = 0
//for x in skills:
//if x >= minLevel and x <= maxLevel:
//count += 1
//
//# Compute the number of teams
//teams = 0
//for r in range(minAssociates, count+1):
//teams += ncr(count, r)
//
//# Print the output
//print("The number of teams that can be created are:", teams)


//import math
//
//# function to compute nCr
//def ncr(n, r):
//return math.factorial(n) // ((math.factorial(n-r) * math.factorial(r)))
//
//# Take input
//num = int(input("num = "))
//skills = list(map(int, input("skills = ").split()))
//minAssociates = int(input("minAssociates = "))
//minLevel = int(input("minLevel = "))
//maxLevel = int(input("maxLevel = "))
//
//# Count skills in the given range
//count = 0
//for x in skills:
//if x >= minLevel and x <= maxLevel:
//count += 1
//
//# Compute the number of teams
//teams = 0
//for r in range(minAssociates, count+1):
//teams += ncr(count, r)
//
//# Print the output
//print("The number of teams that can be created are:", teams)
