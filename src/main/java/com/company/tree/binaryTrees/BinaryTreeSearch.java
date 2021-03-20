package com.company.tree.binaryTrees;

public class BinaryTreeSearch extends BinaryTree {

    public BinaryTreeSearch(int key) {
        super(key);
    }

    boolean contains(Node node, int key){
        if(node == null) return false;
        if(node.getData().compareTo(key) == 0) return true;
        boolean isInLeftSubTree = contains(node.getLeft(), key);
        if(!isInLeftSubTree)
            return contains(node.getRight(), key);
        return isInLeftSubTree;
    }

    public static void main(String[] args) {
        BinaryTreeSearch bts = new BinaryTreeSearch(5);
        bts.getRoot().setLeft(new Node(1));
        bts.getRoot().setRight(new Node(4));
//        bts.printBTree();
        System.out.println("\n"+bts.contains(bts.getRoot(), 5));
    }
}
