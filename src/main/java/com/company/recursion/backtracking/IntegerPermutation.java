package com.company.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,0,9};
        printPermuations(nums);
    }

    private static void printPermuations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) {
            System.out.println(result);
            return;
        }
        Arrays.sort(nums);
        printPermuations(nums, 0, nums.length - 1, result);
        System.out.println(result);
    }

    private static void printPermuations(int[] nums, int low, int high, List<List<Integer>> permutations) {
        if(low == high){
            ArrayList<Integer> permutation = new ArrayList<>();
            for(int num: nums)
                permutation.add(num);
            permutations.add(permutation);
            return;
        }
        for(int i = low; i <= high; i++){
            swap(nums, low, i);
            printPermuations(nums, low + 1, high , permutations);
            swap(nums, low, i);
            while (i < high && nums[i] == nums[i+1]){
                i++;
            }
        }

    }

    private static void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}
