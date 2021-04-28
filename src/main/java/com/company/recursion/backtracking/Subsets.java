package com.company.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3,3};
        Arrays.sort(nums);
        printSubsetsDuplicates(nums);
//        printSubsets(nums);
    }

    private static void printSubsetsDuplicates(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        if(nums.length == 0) {
            System.out.println(subsets);
            return;
        }

        int prev = 0;
        for(int num: nums){
            int i = 0;
            int n = subsets.size();
            if(prev == num)
                i = subsets.size() / 2;
            for(; i < n; i++) {
                List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(num);
                subsets.add(subset);
            }
            prev = num;
        }
        System.out.println(subsets);
    }

    private static void printSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        if(nums.length == 0) {
            System.out.println(subsets);
            return;
        }

        for(int num: nums){
            int n = subsets.size();
            for(int i = 0; i < n; i++) {
                List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(num);
                subsets.add(subset);
            }
        }
        System.out.println(subsets);
    }

//    private static void printSubsets(int[] nums, int low, int high, List<List<Integer>> permutations) {
//        if(low == high+ 1){
//            return;
//        }
//
//        for(int i = low; i <= high; i++){
////            swap(nums, i ,low);
//            printSubsets(nums, low + 1 , high, permutations);
////            swap(nums, i ,low);
////            while (i < high && nums[i] == nums[i+1]){
////                i++;
////            }
//        }
//        ArrayList<Integer> permutation = new ArrayList<>();
//        for(int i = low; i <= high; i++){
//            permutation.add(nums[i]);
//        }
//        permutations.add(permutation);
//
//    }

    private static void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}
