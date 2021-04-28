package com.company.graph.TwoDimMatrix;

public class MatrixTraversal {

    private boolean isValid(int row, int col, boolean[][] visited){
        if(row >= visited.length || col >= visited[0].length || row < 0 || col < 0)
            return false;
        return !visited[row][col];
    }

    void dfs(int row, int col, boolean[][] visited){
        visited[row][col] = true;

        if(isValid(row - 1, col, visited))  // up
            dfs(row - 1, col, visited);

        if(isValid(row, col + 1, visited))   // right
            dfs(row, col + 1, visited);

        if(isValid(row + 1, col, visited)) // down
            dfs(row + 1, col, visited);

        if(isValid(row, col - 1, visited))
            dfs(row, col - 1, visited);
    }

    static void TwoDimTrav(int[][] arr, int row, int col){
        // Direction Vectors
        //        North, South, East, West
        // dr = [  -1,     1,    0,    0  ]
        // dc = [   0,     0,    1,    -1 ]

        // Diagonals
        //         NW     NE    SE     SW
        // dr = [  -1,    -1,    1,    1  ]
        // dc = [  -1,     1,    -1,   1  ]

        int[] dr = new int[]{ -1, 1, 0, 0};
        int[] dc = new int[]{ 0, 0, 1, -1};

        for(int i = 0; i < 4; i++){
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if(newRow < 0 || newCol < 0 || newRow >= arr.length || newCol >= arr[0].length)
                continue;

            // do your code here

        }

        // All Directions
        //        North, South, East, West,  NW     NE    SW     SE
        // dr = [  -1,     1,    0,    0     -1,    -1,    1,    1  ]
        // dc = [   0,     0,    1,    -1    -1,     1,    1,   -1  ]

//        int[] dr = new int[]{ -1, 1, 0, 0, -1, -1, 1, 1};
//        int[] dc = new int[]{ 0, 0, 1, -1, -1, 1, -1, 1};
//
//        for(int i = 0; i < 8; i++){
//            int newRow = row + dr[i];
//            int newCol = col + dc[i];
//
//            if(newRow < 0 || newCol < 0 || newRow >= arr.length || newCol >= arr[0].length)
//                continue;
//
//            // do your code here
//
//        }
    }




    private boolean isValid(int row, int col, int[][] arr){
        if(row >= arr.length || col >= arr[0].length || row < 0 || col < 0)
            return false;
        if(arr[row][col] == 1)
            return false;
        return true;
    }
}
