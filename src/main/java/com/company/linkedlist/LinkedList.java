package com.company.linkedlist;

public class LinkedList {

    private Node head, tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    void addFirst(int elem){
        Node node = new Node(elem);
        if(head == null) {
            tail = node;
        }
        else {
            node.setNext(head);
        }
        head = node;
    }

    public void addLast(int elem){
        Node node = new Node(elem);
        // tail = head = null
        if(head == null){
            head = tail = node;
        }
        else {
            // 1 2 3 4 null
            tail.setNext(node);
            tail = node;
        }
    }
    void addLast(Node node){
        // tail = head = null
        if(head == null){
            head = tail = node;
        }
        else {
            // 1 2 3 4 null
            tail.setNext(node);
            tail = node;
        }
    }

    boolean contains(int elem){
        Node curr = head;
        while (curr != null){
            if(curr.getVal() == elem)
                return true;

            curr = curr.getNext();
        }
        return false;
    }

    void clear(){
        head = null;
    }

    // Removes the head
    int remove(){
        return 0;
    }
    // Return true if number exist in the list and able to delete it
    // remove(5) 5 14 1 7

    void remove(int elem){
        if(head != null){
            if(head.getVal() == elem){
                head = head.getNext();
            }
            Node prev = head;
            Node curr = prev.getNext();
            while (curr != null){
                if(curr.getVal() == elem){
                    prev.setNext(curr.getNext());
                    curr = null;
                    break;
                }
                prev = curr;
                curr = curr.getNext();
            }
        }
    }
    int remove(Node prev) {
        if (prev == null || prev.getNext() == null) {
            System.out.println("Nothing to remove");
            return Integer.MAX_VALUE;
        }
        Node curr = prev.getNext();
        // if removing the tail
        if (curr == tail) {
            tail = prev;
            tail.setNext(null);
        } else {
            // delete node
            prev.setNext(curr.getNext());
            curr = null;
        }
        return curr.getVal();
    }

    public Node getFirst() {
        return head;
    }

    public Node getLast() {
        return tail;
    }

    int secondLastIndexOf(int elem){
        if(head == null)
            return -1;
        int prevOcc = -1;
        int nextOcc = -1;
        Node curr = head;
        int idx = 0;
        while (curr != null){
            if(curr.getVal() == elem){
                prevOcc = nextOcc;
                nextOcc = idx;
            }
            curr = curr.getNext();
            idx++;
        }
        return prevOcc;
    }

    void printTail(Node head){
        System.out.print("Tail : ");
        if(head == null){
            System.out.println("null");
        }
        else {
            System.out.println(tail.getVal());
        }
    }

    void printNodes(Node head){
        System.out.print("LinkedList : ");
        if(head == null)
            System.out.println("null");
        else{
            Node curr = head;
            while (curr != null){
                System.out.print(curr.getVal() + " ");
                curr = curr.getNext();
            }
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(4);
        ll.addFirst(1);
        ll.addLast(2);
        ll.addFirst(3);
        ll.addLast(4);
//        ll.addLast(10);
        ll.addFirst(3);
        ll.addLast(4);
        ll.addLast(10);
        System.out.print("\nSecond Last Idx of 0 : ");
        System.out.println(ll.secondLastIndexOf(0));
        ll.printNodes(ll.head);
        ll.remove(10);
        System.out.println("\nAfter removing 10 : ");
        ll.printNodes(ll.head);
//        ll.addLast(7);
//        ll.clear();
////
//        ll.printTail(ll.head);
//        ll.printNodes(ll.head);
//        ll.addLast(7);
//        ll.addLast(8);
//        ll.printTail(ll.head);
//        System.out.println(ll.contains(15));
//        System.out.println(ll.contains(1));

//        java.util.LinkedList<Integer> linkedList = new java.util.LinkedList<>();
//        linkedList.addFirst(1);
//        linkedList.addFirst(3);
//        System.out.println(linkedList.remove(1));
//        linkedList.contains()
//        Integer node = linkedList.getFirst();

//        System.out.println(linkedList);
    }
}
