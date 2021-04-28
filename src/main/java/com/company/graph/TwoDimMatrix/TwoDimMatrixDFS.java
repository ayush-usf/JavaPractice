package com.company.graph.TwoDimMatrix;

import java.util.Arrays;
import java.util.Stack;

public class TwoDimMatrixDFS {

    private static boolean isValid(int row, int col, boolean[][] visited){
        if(row >= visited.length || col >= visited[0].length || row < 0 || col < 0)
            return false;
        return !visited[row][col];
    }

    static void twoDimMatrixDFS(int[][] dist, int row, int col, boolean[][] visited){

        visited[row][col] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1 ,-1};

        for(int i = 0; i < 4; i++){
            if(isValid(row + dr[i], col + dc[i], visited)){
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                dist[newRow][newCol] = dist[row][col] + 1;
                visited[newRow][newCol] = true;
                twoDimMatrixDFS(dist, newRow, newCol, visited);
            }
        }
    }

    static void twoDimMatrixDFSIterative(int[][] grid) {
        if (grid.length == 0)    return;

        int rowCnt = grid.length;
        int colCnt = grid[0].length;

        Stack<int[]> stack = new Stack<>();
        boolean[][] visited = new boolean[rowCnt][colCnt];

        stack.push(new int[]{0, 0});
        grid[0][0]= 0;

        while (!stack.isEmpty()) {
            int[] node = stack.pop();
            int row = node[0];
            int col = node[1];

            if(row < 0 || col < 0 || row >= rowCnt || col >= colCnt)
                continue;
            if(visited[row][col])   continue;

            visited[row][col] = true;
            System.out.print(grid[row][col] + " ");

            stack.push(new int[]{row - 1, col});    // North
            stack.push(new int[]{row + 1, col});    //  South
            stack.push(new int[]{row , col + 1});   //  East
            stack.push(new int[]{row , col - 1});   //  West
        }
    }

    /*  {0, 5, 6},
        {1, 4, 7},
        {2, 3, 8}
    */
    // Zig-Zag Row Traversal
    // 0 5 6 7 4 1 2 3 8



    public static void main(String[] args) {
//        boolean[][] visited = new boolean[3][3];
//        twoDimMatrixDFS(distance, 0, 0 ,visited);
        int[][] distance = new int[][]{
                {0, 5, 6},
                {1, 4, 7},
                {2, 3, 8}
        };

        twoDimMatrixDFSIterative(distance);

//        for(int i = 0; i < 3; i++)
//            System.out.println(Arrays.toString(distance[i]));
    }
}


