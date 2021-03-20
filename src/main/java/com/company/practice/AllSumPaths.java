package com.company.practice;

import java.util.ArrayList;
import java.util.List;

public class AllSumPaths {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static List<List<Integer>> findPaths(TreeNode tree, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(tree,sum, new ArrayList<>(), paths);
        return paths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        System.out.println(findPaths(root,sum));
    }
//    private static void findPaths(TreeNode tree, int sum, ArrayList<Integer> path, List<List<Integer>> paths) {
//        if(tree == null) return;
//        if (sum == tree.data) {
//            path.add(tree.data);
//            paths.add(path);
//            return;
//        }
//        sum = sum - tree.data;
//        path.add(tree.data);
//        findPaths(tree.left,sum, new ArrayList<>(path), paths);
//        findPaths(tree.right,sum, new ArrayList<>(path), paths);
//    }
    private static void findPaths(TreeNode tree, int sum, ArrayList<Integer> path, List<List<Integer>> paths) {
        if(tree == null) return;

        path.add(tree.data);

        if (sum == tree.data && tree.left == null && tree.right == null) {
            paths.add(path);
        }
        else {
            sum = sum - tree.data;
            findPaths(tree.left, sum, new ArrayList<>(path), paths);
            findPaths(tree.right, sum, new ArrayList<>(path), paths);
        }
        path.remove(tree.data);
    }
}

// 4 , [12,7, 4] sum = 4
// null , [12,7 sum = 4

// 1 , [12, sum = 10

// [12,7, 4],
