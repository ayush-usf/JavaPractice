package com.company.linkedlist;

public class Node {
    private int val;
    private Node next;
    private Node prev;

    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }

    public Node(int val){
        this.val = val;
        this.next = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        System.out.println(node.getVal());
        System.out.println(node.getNext());
        node.setVal(2);
        System.out.println(node.getVal());
        Node node2 = new Node(10);
        node.setNext(node2);
        System.out.println(node.getNext().getVal());
    }
}
