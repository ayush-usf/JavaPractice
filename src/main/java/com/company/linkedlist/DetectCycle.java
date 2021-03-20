package com.company.linkedlist;

public class DetectCycle {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        Node node = ll.getLast();
        ll.addLast(2);
//        ll.addLast(3);
//        ll.addLast(4);
//        ll.addLast(5);
//        ll.addLast(6);
        addCycle(ll.getLast(), node);
//        ll.printNodes(ll.getFirst());
        System.out.println(detectCycle(ll.getFirst()));
    }

    private static void addCycle(Node tail, Node node) {
        tail.setNext(node);
    }

    private static boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast)
                return true;
        }
        return false;
    }
}
