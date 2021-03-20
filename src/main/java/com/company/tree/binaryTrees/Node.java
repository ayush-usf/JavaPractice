package com.company.tree.binaryTrees;

public class Node {
    public Comparable data;
    public Node left;
    public Node right;
    public Node next;

    public Node(Comparable data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node() {

    }

    public void setData(Comparable data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(Comparable data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Comparable getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        return getData().toString();
    }
}
