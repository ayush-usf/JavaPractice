package com.company.graph.TwoDimMatrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TwoDimMatrixBFS {

    private static boolean isValid(int row, int col, boolean[][] visited){
        if(row >= visited.length || col >= visited[0].length || row < 0 || col < 0)
            return false;
        return !visited[row][col];
    }

    static void twoDimMatrixBFS(int[][] grid, int row, int col){

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[3][3];

        queue.offer(new int[]{row, col});

        grid[row][col] = 0;
        visited[row][col] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1 ,-1};

        while (!queue.isEmpty()){
            // This one will always be visited
            // We use it to get its neighbours
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];

            for(int i = 0; i < 4; i++){
                if(isValid(r + dr[i], c + dc[i], visited)){
                    int newRow = r + dr[i];
                    int newCol = c + dc[i];

                    grid[newRow][newCol] = grid[r][c] + 1;
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    /*
        [0, 1, 2]
        [1, 2, 3]
        [2, 3, 4]
    */

    public static void main(String[] args) {
        int[][] gridance = new int[3][3];
        twoDimMatrixBFS(gridance, 0, 0);
        for(int i = 0; i < 3; i++)
            System.out.println(Arrays.toString(gridance[i]));
    }
}
