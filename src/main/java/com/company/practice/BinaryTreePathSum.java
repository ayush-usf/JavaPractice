package com.company.practice;

public class BinaryTreePathSum {
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


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println(hasPath(root, 23));
        System.out.println(hasPath(root, 16));
    }

    private static boolean hasPath(TreeNode tree, int reqdSum) {
        // 2 base Case Conditions
        if(tree == null || reqdSum < 0) return false;
        if(tree.data == reqdSum) return true;

        // Main Case
        reqdSum = reqdSum - tree.data;
        boolean hasSum = hasPath(tree.left, reqdSum);
        if(hasSum) return true;
        return hasPath(tree.right, reqdSum);
    }
}
