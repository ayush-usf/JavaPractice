package com.company.linkedlist;

import java.util.HashSet;

public class Intersection {
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        ll1.addLast(1);
        ll1.addLast(2);
        ll1.addLast(3);
        ll2.addLast(10);
        ll2.addLast(8);
        Node node1 = new Node(7);
        Node node2 = new Node(11);
        Node node3 = new Node(15);
        node1.setNext(node2);
        node2.setNext(node3);
        ll1.getLast().setNext(node1);
        ll2.getLast().setNext(node1);

        ll1.printNodes(ll1.getFirst());
        ll2.printNodes(ll2.getFirst());
        Node intersecting = getIntersectionNode(ll1.getFirst(), ll2.getFirst());
        System.out.println(intersecting.getVal());
    }

    // Method 1 - Time O(max(n1,n2)) | Space: O(1)
    private static Node getIntersectionNode(Node head1, Node head2) {
        int len1 = getLenLinkedList(head1);
        int len2 = getLenLinkedList(head2);
        int diff = Math.abs(len1 - len2);
        int counter = 0;
        while (counter < diff){
            if(len1 > len2)
                head1 = head1.getNext();
            else
                head2 = head2.getNext();
            counter++;
        }
        while (head1 != null && head2 != null){
            if(head1 == head2)
                return head1;
            head1 = head1.getNext();
            head2 = head2.getNext();
        }
        return null;
    }

    private static int getLenLinkedList(Node head) {
        int len = 0;
        while (head != null){
            len++;
            head = head.getNext();
        }
        return len;
    }

    // Method 2 - Don't need to iterate both arrays, Space - O(n1/n2)
//    public static Node getIntersectionNode(Node headA, Node headB) {
//        HashSet<Node> set = new HashSet<>();
//        Node curr = headB;
//        while(curr != null){
//            set.add(curr);
//            curr = curr.getNext();
//        }
//
//        curr = headA;
//        while(curr != null){
//            if(set.contains(curr))
//                return curr;
//            curr = curr.getNext();
//        }
//        return null;
//    }
}
