package com.company.tree.binaryTrees;

public class HeightBalancedBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createTree();
        binaryTree.printInorderIter(binaryTree.getRoot());
        System.out.println(checkHeightBalance(binaryTree.getRoot()));
    }

    private static boolean checkHeightBalance(Node root) {
        if(root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);

        if(Math.abs(lh- rh) < 2){
            return checkHeightBalance(root.left) && checkHeightBalance(root.right);
        }
        return false;
    }

    private static int height(Node tree) {
        if(tree == null) return 0;
        return 1+ Math.max(height(tree.left), height(tree.right));
    }
}
