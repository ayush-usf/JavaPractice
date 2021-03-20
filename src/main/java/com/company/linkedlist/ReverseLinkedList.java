package com.company.linkedlist;

import java.util.Stack;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(3);
        ll.addFirst(9);
        ll.addFirst(13);
        ll.addFirst(8);
        ll.addFirst(12);
        ll.printNodes(ll.getFirst());
//        Node newHead = reverseLinkedListLowHigh(ll.getFirst(), 2, 3);
        Node newHead = reverseLinkedListLowHigh(ll.getFirst(), 8, 1);
//        Node newHead = reverseLinkedList(ll.getFirst());
//        Node newHead = reverseLinkedListWithStack(ll.getFirst());
        ll.printNodes(newHead);
    }

    // 1 2 3 8 12

    private static Node reverseLinkedListLowHigh(Node head, int low, int high) {
        Node curr = head;
        Node prev = null;
        Node nextRef = null;

        while (curr != null && curr.getVal()!= low){
            prev = curr;
            curr = curr.getNext();
        }
        Node start = prev; //  chain starts here
        prev = curr;    // for low val

        while (curr != null && curr.getVal()!= high){
            nextRef = curr.getNext();

            // Occurence of prev might change
            // Swapping
            curr.setNext(prev);
            prev = curr;
            curr = nextRef;
        }
        nextRef = curr.getNext();
        curr.setNext(prev);
        prev = curr;
        curr = nextRef;

        while (prev != null && prev.getVal()!=low){
            start.setNext(prev);
            start = start.getNext();
            prev = prev.getNext();
        }
        start.setNext(prev); // for low val
        start = start.getNext();

        start.setNext(curr);
        return head;
    }

    static Node reverseLinkedList(Node head){
        Node curr = head;
        Node prev = null;
        Node nextRef = null;

        while (curr != null){
            nextRef = curr.getNext();

            // reversing the nodes
            curr.setNext(prev);
            prev = curr;

            // iterating normally
            curr = nextRef;
        }
        return prev;
    }


    private static Node reverseLinkedListOld(Node head) {
        Node curr = head;
        Node prev = null;
        Node nextRef = null;

        while (curr != null){
            // Storing next reference
            nextRef = curr.getNext();

            // Reversing the nodes
            curr.setNext(prev);
            prev = curr;

            // Continuing Normal iteration
            curr = nextRef;
        }
        return prev;
    }

    private static Node reverseLinkedListWithStack(Node head) {
        if(head == null) return  null;

        Stack<Integer> stack = new Stack<>();
        Node curr = head;

        // Filling the Stack
        while (curr != null){
            stack.add(curr.getVal());
            curr = curr.getNext();
        }

        // Creating new New Linked List
        Node newHead = null;
        Node newCurr = newHead;
        while (stack.size() > 0){
            Node node = new Node(stack.pop());
            if (newHead == null) {
                newHead = node;
                newCurr = node;
            }
            else {
                newCurr.setNext(node);
                newCurr = newCurr.getNext();
            }
        }
        return newHead;
    }
}
