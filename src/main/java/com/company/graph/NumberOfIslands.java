package com.company.graph;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
public class NumberOfIslands {

    /*
      [0,0,1,1],
      [1,1,0,0],
      [1,0,0,0]]
    */
    public static int noOfIslands(int[][] arr){
        if(arr.length == 0) return 0;
        int islandCnt = 0;
        for (int i = 0; i< arr.length; i++) {
            for (int j = 0 ; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    islandCnt++;
                    getRidOfRestOfIsland(arr, i, j);
                }
            }
        }
        return islandCnt;
    }

    public static void getRidOfRestOfIsland(int[][] arr, int i, int j){

        if(i >= 0  && j >= 0  && i < arr.length && j < arr[i].length){
            if(arr[i][j] == 1) {
                arr[i][j] = 0;
                getRidOfRestOfIsland(arr, i - 1,  j); // top
                getRidOfRestOfIsland(arr, i + 1,  j); // bottom
                getRidOfRestOfIsland(arr, i,  j + 1); // right
                getRidOfRestOfIsland(arr, i  ,  j - 1); // left
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[4][];
        arr[0] = new int[]{1,0,1,1};
        arr[1] = new int[]{0,0,1,1};
        arr[2] = new int[]{1,1,0,0};
        arr[3] = new int[]{1,0,0,0};
        int islandCnt = noOfIslands(arr);
        System.out.println("islandCnt "+islandCnt);
    }
}

// return -1; // visited

//       if(getRidOfRestOfIsland(arr, i - 1,  j) == 1){ // top

//          }
//       if(getRidOfRestOfIsland(arr, i,  j + 1) == 1){  // right

//       }
//       if(getRidOfRestOfIsland(arr, i + 1,  j) == 1){ // bottom
//          getRidOfRestOfIsland(arr, i +1 ,  j);
//       }
//       if(getRidOfRestOfIsland(arr, i ,  j - 1) == 1){ // left

//       }

// if(arr[i][j] == 1)  // visited
// return sum;

// if(arr[i][j] == 1) arr[i][j] = 7; // visited
//       sum++;

//        if(noOfIslands(arr, i + 1,  j) == 1 || noOfIslands(arr, i + 1,  j + 1) == 1  || noOfIslands(arr, i,  j + 1) == 1)          {
//          if(arr[i][j] != 7)
//             sum++;

//        }


//       j++;



// i < arr.length && j < arr[0].length && i > 0  && j > 0
// node.right [i][j+1]== 1
// node.bottom [i+1][j]== 1
// node.bottom_right [i+1][j+1]== 1
// increase overall foundSum


//        int i = 0, j = 0;
// islandCnt  = noOfIslands(arr,i, j);
