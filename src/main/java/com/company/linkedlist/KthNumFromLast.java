package com.company.linkedlist;

public class KthNumFromLast {
    // Kth smallest elements with index starting from 1
    // Move fast pointer (k) times

    // K+1th smallest elements with index starting from 0
    // Move fast pointer (k+1) times

    // Keep constant distance between slow and fast pointer
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        System.out.println(kthNumFromLast(ll.getFirst(), 3));
    }
    // k = 3
    // 1 2
    //   p   q

    public static int kthNumFromLast(Node head, int k) {
        Node ptr1 = head;
        Node ptr2 = head;
        int counter = 0;
        while (counter != k && ptr2 != null){
            ptr2 = ptr2.getNext();
            counter++;
        }
        if(counter < k)
            return  -1;

        while (ptr2 != null){
            ptr1 = ptr1.getNext();
            ptr2 = ptr2.getNext();
        }
        return ptr1.getVal();
    }
}
