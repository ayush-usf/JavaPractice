package com.company.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixSpiralTraversal {

    // [[ 1,  2,  3,  4,  5],
    //  [ 6,  7,  8,  9, 10],
    //  [11, 12, 13, 14, 15],
    //  [16, 17, 18, 19, 20],
    //  [21, 22, 23, 24, 25]]

    // Clockwise
    // 1. Print diff col |  1. Complete [start_col, end_col]
    // 2. Print diff row |  2. Leave from 1 side [row + 1, end_row]
    // 3. Print diff col |  3. Leave from 2 sides [end_col - 1, start_col)
    // 4. Print diff row |  4. Leave from 1 side [end_row, start_row)
    // start [r,c] ++, end [r, c]--

    // Counter Clockwise
    // 1. Print diff col |  1. Complete [start_col, end_col]
    // 2. Print diff row |  2. Leave from 1 side [row + 1, end_row]
    // 3. Print diff col |  3. Leave from 2 sides [end_col - 1, start_col)
    // 4. Print diff row |  4. Leave from 1 side [end_row, start_row)

    // SpiralMatrix 3 - Clockwise
    // 1. Print diff col |  1. Complete [start_col, end_col]
    // 2. Print diff row |  2. Leave from 1 side [row + 1, end_row]
    // 3. Print diff col |  3. Leave from 1 sides [end_col - 1, start_col]
    // 4. Print diff row |  4. skip none [end_row, start_row]
    // end [r,c] ++, start [r,c]--

    static void printSpiralCounter(int[][] inputArr){

        // 1. print diff row | Complete [start_row, end_row]
        // 2. print diff col | skip 1 [start_col + 1, end_col]
        // 3. print diff row | skip 2 [end_row - 1, start_row + 1]
        // 4. print diff col | skip 1 [end_col , start_col +1]

        int start_row = 0;
        int end_row = inputArr.length - 1;
        int start_col = 0;
        int end_col = inputArr[0].length - 1;

        while(start_row <= end_row && start_col <= end_col){

            for(int r = start_row; r <= end_row ; r++)
                System.out.println(inputArr[r][start_col]);

            for(int c = start_col + 1; c <= end_col; c++)
                System.out.println(inputArr[end_row][c]);

            if(start_row < end_row && start_col < end_col){

                for(int r = end_row -1; r > start_row; r--)
                    System.out.println(inputArr[r][end_col]);

                for(int c = end_col; c > start_col ; c--)
                    System.out.println(inputArr[start_row][c]);
            }
            start_row++;
            start_col++;
            end_col--;
            end_row--;
        }
    }

    public static List <Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0)
            return ans;

        int start_row = 0;
        int end_row = matrix.length - 1;
        int start_col = 0;
        int end_col = matrix[0].length - 1;

        int k = 1;
        while (start_row <= end_row && start_col <= end_col) {

            // Print diff col |  1. Complete [start_col, end_col]
            for (int c = start_col; c <= end_col; c++)
                matrix[start_row][c] = k++;

            // 2. Print diff row |  2. Leave from 1 side [row + 1, end_row]
            for (int r = start_row + 1; r <= end_row; r++)
                matrix[r][end_col] = k++;

            if (start_row < end_row && start_col < end_col) {

                //  3. Print diff col |  3. Leave from 2 sides [end_col - 1, start_col)
                // As we are skipping 2, extra elements will be skipped [good thing]
                for (int c = end_col - 1; c > start_col; c--)
                    matrix[end_row][c] = k++;

                // 4. Print diff row |  Leave from 1 side [end_row, start_row)
                // As we are skipping by just 1, extra elements might not always skipped [bad]
                // e.g. [[3],[2]], so we have put an extra if inside while
                for (int r = end_row; r > start_row; r--)
                    matrix[r][start_col] = k++;
            }
            start_row++;
            start_col++;
            end_row--;
            end_col--;
        }
        return ans;
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int i = 0;
        int n = R * C;
        int[][] res = new int[R*C][2];

        int start_row = r0;
        int start_col = c0;
        int end_row = r0 + 1;
        int end_col = c0 + 1;

        while(i < n && start_row <= end_row && start_col < end_col){
            // 1.print cols | 1. complete
            for (int c = start_col; c <= end_col; c++){
                if(isValid(start_row , c, R, C))
                    res[i++] = new int[]{start_row, c};
            }
            // 2. print rows | skip 1 [start_row+1, end_row]
            for (int r = start_row + 1; r <= end_row; r++) {
                if (isValid(r, end_col, R, C))
                    res[i++] = new int[]{r, end_col};
            }

            if (start_row < end_row && start_col < end_col) {
                // 3. print cols | skip 1 [end_col - 1, start_col] [extend 1 more than normal]
                for (int c = end_col - 1; c >= start_col ; c--) {
                    if (isValid(end_row, c, R, C))
                        res[i++] = new int[]{end_row, c};
                }

                // 4. print row | skip none [end_row , start_row]
                for (int r = end_row; r >= start_row ; r--) {
                    if (isValid(r, start_col - 1, R, C))
                        res[i++] = new int[]{r, start_col - 1};
                }
            }
            end_col++;
            end_row++;

            start_row--;
            start_col--;
        }
        return res;
    }

    static boolean isValid(int newR, int newC, int R, int C){
        // System.out.println(newR +" | " + newC);
        if (newR < 0 || newC < 0 || newR >= R || newC >= C)
            return false;
        return true;
    }
    // Driver Code
    public static void main(String[] args)
    {
        int a[][] = new int[][]{
                            { 1, 2,  3,  4 , 18},
                            { 5, 6,  7,  8,  19},
                            { 9, 10, 11, 12, 20},
                            { 13,14, 15, 16 , 21},
                            { 22,23, 24, 25 , 26}
                        };
        System.out.println(spiralOrder(a));
        for (int i = 0; i < a.length; i++){
            System.out.println(Arrays.toString(a[i]));
        }
    }
}