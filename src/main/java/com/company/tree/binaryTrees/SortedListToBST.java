package com.company.tree.binaryTrees;

import java.util.*;
import com.company.linkedlist.LinkedList;

public class SortedListToBST {

    public static void main(String[] args) {
        SortedListToBST bst = new SortedListToBST();
        //        Node head = bst.arrayToBST(list);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        Node head = bst.listToBST(ll.getFirst());
        bst.levelOrderTraversal(head);
    }

    private static Node listToBST(com.company.linkedlist.Node tree) {
//        return listToBST(mid, 0, list.size() - 1);
        return new Node();
    }

    private static Node arrayToBST(ArrayList<Integer> list) {
        return arrayToBST(list, 0, list.size() - 1);
    }
    private static Node arrayToBST(ArrayList<Integer> list, int low, int high) {
        int mid = low + (high - low)/2;
        Node middle = new Node(list.get(mid));
        if(low == high) return middle;
        middle.left = arrayToBST(list, low, mid -1);
        middle.right = arrayToBST(list, mid + 1, high);
        return middle;
    }

    protected void levelOrderTraversal(Node tree) {
        if(tree == null) return;
        Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
}
