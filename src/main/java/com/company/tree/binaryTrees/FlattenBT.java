package com.company.tree.binaryTrees;

import com.company.linkedlist.LinkedList;

public class FlattenBT extends BinaryTree{
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createTree();
        flattenBinaryTreeToLinkedList(binaryTree.getRoot());
    }

    private static Node flattenBinaryTreeToLinkedList(Node tree) {
        LinkedList ll = new LinkedList();
        return tree;
    }
}
