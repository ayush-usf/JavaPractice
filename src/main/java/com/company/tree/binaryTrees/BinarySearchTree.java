package com.company.tree.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree{

    private Node root;

    public BinarySearchTree() {
    }

    public Node getRoot() {
        return root;
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public BinarySearchTree(Comparable elem) {
        this.root = new Node(elem);
    }

    protected void levelOrderTraversal(Node tree) {
        if(tree == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);
//        int idx = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
//            idx++;
        }
    }

    class Node {
        public Comparable data; // value stored at the node
        public Node left; // left subtree
        public Node right;  // right subtree

        Node(Comparable newdata) {
            data = newdata;
        }
    }

    boolean find(Node tree, Comparable elem) {
        if (tree == null) return false;
        if (elem.compareTo(tree.data) == 0)
            return true;
        if (elem.compareTo(tree.data) < 0)
            return find(tree.left, elem);
        else
            return find(tree.right, elem);
    }
    public boolean contains(Comparable elem) {
        return find(root, elem);
    }

    public void delete(Comparable elem) {
        delete(root, elem);
    }

    public void delete(Node tree, Comparable elem) {
        if(elem != tree.data && tree.left == null && tree.right == null)
            return;
        if(elem != tree.data){
            // deleting at left i.e. no child
            if (tree.left == null && tree.right == null) {
                tree = null;
            }
            // recursive case
            // deleting node with 1 child - will never be in base case
            if ((tree.left == null && tree.right != null) || (tree.left != null && tree.right == null)) {
                tree = null;
            }
        }

    }

    // height - length of the path to the deepest node + 1
    int height(Node tree){
        if(tree == null) return 0;
        return 1 + Math.max(height(tree.left), height(tree.right));
    }

    int numNodes(Node tree) {
        if(tree == null) return 0;
        return 1 // for this node
                + numNodes(tree.left)
                + numNodes(tree.right);
    }

    // tail call recursion
    int numLeaves(Node tree) {
        if(tree == null) return 0;
        if(tree.left == null && tree.right == null) return 1;
        return numLeaves(tree.left)
                + numLeaves(tree.right);
    }
    // tail call recursion
    int depth(Node tree, Node toFind, int level){
        if(tree == null) return level;
        if(tree == toFind) return level;
        if(toFind.data.compareTo(tree.data) < 0)
            return depth(tree.left, toFind, level + 1);
        else
            return depth(tree.right, toFind,level + 1);
    }
    // tail call recursion
    public static Node findNode(Node tree, Comparable key){
        if(tree == null) return null;
        if(tree.data == key) return tree;
        if(key.compareTo(tree.data) < 0){
            return findNode(tree.left, key);
        }
        else{
            return findNode(tree.right, key);
        }
    }

    public void print() {
        if(root == null) System.out.println("N/A");
        System.out.println();
        print(root, 0);
    }

    private void print(Node node, int level){
        if(root == null) { return; }
        System.out.println("level " + level + " - " + node.data + " ");
        if(node.left != null)
            print(node.left, level+1);
        if(node.right != null)
            print(node.right, level+1);
        System.out.println();
    }

    public void insert(Comparable key) {
        insert(root, key);
    }


//    public Node insert(Node tree, Comparable key) {
//        if(tree == null) return new Node(key);
//        if(key.compareTo(tree.getData()) < 0){
//            tree.setLeft(insert(tree.getLeft(), key));
//            return tree;
//        }
//        else {
//            tree.setRight(insert(tree.getRight(), key));
//            return tree;
//        }
//    }

    /** When doing tree.left = insert(...., it is required for only the leaf nodes
     *  but we do it for other level subtrees, as we have to re-use the code in recursion
     * @param tree It is the head of a tree/ subtree that represents that entire subtree
     * @return the entire subtree from its head
     */
    public Node insert(Node tree, Comparable data) {
        if(tree == null)    // This new generated node represents the entire tree/subtree
            return new Node(data);

        if(data.compareTo(tree.data) < 0){
            tree.left = insert(tree.left, data);
            return tree;
        }
        else {
            tree.right =  insert(tree.right, data);
            return tree;
        }
    }

    public static int rangeSumBST(Node root, int low, int high) {
        if(root == null) return 0;
        int val = (int) root.data;
        if(val < low)
            return rangeSumBST(root.right, low, high);
        if(val > high)
            return rangeSumBST(root.left, low, high);

        return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + val;
    }

    //    5
    //  3   8
    //1    6
    // 2

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(5);
        bst.insert(3);
        bst.insert(1);
        bst.insert(8);
        bst.insert(6);
        bst.insert(2);
//        bst.print();
        System.out.println(rangeSumBST(bst.getRoot(), 3,8));
//        System.out.println("height : " + bst.height(bst.root));
//        Node node = findNode(bst.root, 4);
//        System.out.println("node : " + node.data);
//        System.out.println("depth of node : " + bst.depth(bst.root, node,0));
//        System.out.println("Number of nodes : " + bst.numNodes(bst.root));
        System.out.println("Number of leaves : " + bst.numLeaves(bst.root));
//        bts.getRoot().setLeft(new Node(1));
//        bts.getRoot().setRight(new Node(4));
//        bts.printBTree();
//        System.out.println("\n"+bts.contains(bts.getRoot(), 5));
    }
}
