package com.company.linkedlist;

public class BinarySearch {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.printNodes(ll.getFirst());
        System.out.println("Index is : "+binarySearchNum(ll.getFirst(),3));
    }

    private static int binarySearchNum(Node head, int num) {
        int idx = -1;
        Node slow = head;
        Node fast = head;
        while (fast!= null){
            idx++;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        if(slow.getVal() == num)
            return idx;
        return idx;
    }
}
