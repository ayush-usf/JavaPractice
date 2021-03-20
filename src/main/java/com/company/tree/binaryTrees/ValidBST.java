package com.company.tree.binaryTrees;

public class ValidBST extends BinaryTree{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createTree();
        tree.levelOrderTraversal(tree.getRoot());
        print(tree.getRoot());
        System.out.println(isBSTValid(tree.getRoot()));
    }

    static boolean isBSTValid(Node tree){
        return isBSTValid(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTValid(Node tree, int minValue, int maxValue) {
        if(tree == null) return  true;
        if(tree.data.compareTo(minValue) < 0 || tree.data.compareTo(maxValue) >= 0) {
            System.out.println("Failed at  : "+ tree.data);
            return false;
        }
        return isBSTValid(tree.left,minValue, (Integer) tree.data) && isBSTValid(tree.right, (Integer) tree.data, maxValue);
    }
















    public static void print(Node root) {
        if(root == null) System.out.println("N/A");
        System.out.println();
        print(root, 0);
    }

    private static void print(Node tree, int level){
        if(tree == null) { return; }
        System.out.println("level " + level + " - " + tree.data + " ");
        if(tree.left != null)
            print(tree.left, level+1);
        if(tree.right != null)
            print(tree.right, level+1);
        System.out.println();
    }
}
