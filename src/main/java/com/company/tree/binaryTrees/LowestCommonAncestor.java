package com.company.tree.binaryTrees;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createSmallTree();
        System.out.println(lowestCommonAncestor(binaryTree.getRoot(),4,9));
    }

    private static Node lowestCommonAncestor(Node tree, int val1, int val2) {
        if(tree == null) return null;
        if(tree.data.compareTo(val1) == 0  || tree.data.compareTo(val2) == 0) return tree;

        Node left = lowestCommonAncestor(tree.left, val1, val2);
        Node right = lowestCommonAncestor(tree.right, val1, val2);

        // If got nothing on left, return right
        if(left == null) return right;
        // If got nothing on right, return left
        if(right == null) return left;

        // Handles both condition
        // 1. Got from both
        // 2. Got from none
        return tree;
    }
}
