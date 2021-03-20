package com.company.recursion.backtracking;

import java.util.Arrays;

public class MazeProblem {
    public static void main(String[] args) {
        int[][] arr = new int[4][];
        arr[0] = new int[]{1, 0, 0, 0};
        arr[1] = new int[]{1, 1, 0, 1};
        arr[2] = new int[]{0, 1, 0, 0};
        arr[3] = new int[]{1, 1, 1, 1};
        solveMaze(arr,0 ,0);
    }

    private static boolean solveMaze(int[][] arr, int row, int col) {
        printArray(arr);
        boolean done = false;
        if(row == arr.length -1 && col == arr[0].length -1) {
            System.out.println("Reached !!!");
            return true;
        }
        if(arr[row][col] == 0){
            arr[row][col] = 3; // tried
            return false;
        }
        arr[row][col] = 7; // path

        if(col >= 0 && col <= arr[row].length -1 && row >= 0 && row <= arr.length -1) {
            done = solveMaze(arr, row, col + 1);
            if (!done) {
                done = solveMaze(arr, row + 1, col);

            }
            if (!done) {
                solveMaze(arr, row - 1, col);
            }
            if (!done) {
                solveMaze(arr, row , col - 1);
            }
        }
        return done;
    }

    private static void printArray(int[][] arr) {
        for(int i = 0; i< arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("\n\n");
    }
}
