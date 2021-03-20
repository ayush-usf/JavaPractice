package com.company.linkedlist;

public class RemoveNodesWithkVal {
    // [3, 1, 2, 3, 4, 5]
    public static void main(String[] args) {
        int k =3;
        LinkedList ll = new LinkedList();
        ll.addLast(3);
        ll.addLast(1);
        ll.addLast(2);
//        ll.addLast(3);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
//        ll.addLast(3);
        ll.printNodes(ll.getFirst());
//        Node newHead = removeNodesWithKVal(ll.getFirst(), k);
        Node newHead = removeNodesWithKValWithCurr(ll.getFirst(), k);
        ll.printNodes(newHead);
    }

    private static Node removeNodesWithKVal(Node head, int k) {
        while (head != null && head.getVal() == k)
            head = head.getNext();

        if(head == null) return  null;

        Node prev = head;
        Node curr = head.getNext();
        while (curr != null){
            while (curr!= null && curr.getVal()!= k){
                prev = curr;
                curr = curr.getNext();
            }
            while (curr != null && curr.getVal() == k){
                curr = curr.getNext();
                prev.setNext(curr);
            }
        }
        return head;
    }

    private static Node removeNodesWithKValWithCurr(Node head, int k) {
        while (head != null && head.getVal() == k)
            head = head.getNext();
        if(head == null) return null;

        Node curr = head;
        while (curr != null){
            while(curr!= null && curr.getNext()!= null && curr.getNext().getVal() != k){
                curr = curr.getNext();
            }

            while(curr!= null && curr.getNext()!= null && curr.getNext().getVal() == k){
                curr.setNext(curr.getNext().getNext());
                curr = curr.getNext();
            }
            if(curr.getNext()== null)
                break;
        }
        return head;
    }
}
