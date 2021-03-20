package com.company.practice;

public class SumPathNumbers {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println(sumAllPaths(root));
    }

    private static int sumAllPaths(TreeNode tree) {
        return sumAllPaths(tree, "");
    }
    private static int sumAllPaths(TreeNode tree, String number){
        if(tree == null) return 0;
        if(tree.left == null && tree.right == null)
            return Integer.parseInt(number + tree.data);
        return sumAllPaths(tree.left, number + tree.data) +
                sumAllPaths(tree.right, number + tree.data);
    }
}
// 1
// 0, "1"
// 1, "1"

// 9, "19"

//  17 + 192 + 199
// k =
