package com.company.linkedlist;

public class MiddleNode {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        System.out.println(middleNodeLinkedList(ll.getFirst()));
    }

    // 1 2 3 4 5 6
    //     S       F
    private static int middleNodeLinkedList(Node head) {
        if(head == null)  return -1;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            if(fast.getNext() == null)
                break;
            fast = fast.getNext().getNext();
        }
        return slow.getVal();
    }
}
