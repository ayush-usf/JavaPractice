package com.company.tree.binaryTrees;

import java.util.*;

public class BinaryTree {
    // Root of Binary Tree
    Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Comparable key) {
        this.root = new Node(key);
    }


    int height(Node tree){
        if(tree == null) return 0;
        return 1 + Math.max(height(tree.left), height(tree.right));
    }

    private Node successor(Node tree, int predKey) {
        if(tree == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(tree);
        boolean preFound = false;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(preFound)
                return node;
            if(node.data.compareTo(predKey) == 0){
                preFound = true;
            }
            if(node.left != null)   queue.offer(node.left);
            if(node.right != null)   queue.offer(node.right);
        }
        return  null;
    }

    // With stack data/visited still remains first
    // but left is swapped with right, as while
    // popping out of stack, order with be reversed
    // i.e. left, right. Overall order - data, left, right
    protected void printPreorderIter(Node tree) {
        if(tree == null) return;
        Stack<Node> stack  = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.data+ " ");
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
                // Once we pop left out, we
                // print it before its left,
                // right, as it was parent.
                // Order-parent, left, right
        }
    }

    protected void printPostorderIter(Node tree) {
        if(tree == null) return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(tree);
        while (!stack1.isEmpty()){
            tree = stack1.pop();
            stack2.push(tree);
            if (tree.left != null)
                stack1.push(tree.left);
            if(tree.right != null)
                stack1.push(tree.right);
        }
        while (!stack2.isEmpty())
            System.out.print(stack2.pop().data + " ");
    }

    protected void printInorderIter(Node tree) {
        if(tree == null) return;
        Stack<Node> stack = new Stack<>();
        while (true){
            if(tree != null){
                stack.push(tree);
                // Trying to go as left as possible
                tree = tree.left;
            }
            else {
                if(stack.isEmpty())
                    break;
                tree = stack.pop();
                System.out.print(tree.data + " ");
                // Going right once, left part is done
                tree = tree.right;
            }
        }
    }

    void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if(node.left != null)   queue.add(node.left);
            if(node.right != null)  queue.add(node.right);
        }
    }

    public List<List<Integer>> levelOrder(Node tree){
        List<List<Integer>> list = new LinkedList<>();
        if(tree == null) return list;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(tree);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            ArrayList<Integer> subList = new ArrayList<>(levelSize);
            for(int i = 0; i < levelSize; i++){
                Node node = queue.poll();
                subList.add((Integer) node.data);

                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            list.add(subList);
        }
        return list;
    }

    private int minDepthOfBinTree(Node tree) {
        if(root == null) return  0;
        int minDepth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(tree);
        int depth = 0;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                Node node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                else if(node.right == null){
                    return depth;
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return minDepth;
    }


    private List<Integer> rightView(Node root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                Node node = queue.poll();
                if(i == levelSize - 1) list.add((Integer) node.data);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return list;
    }

    public List<List<Integer>> zigZagTraversal(Node tree){
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(tree);
        boolean levelToRight = true;
        while (!queue.isEmpty()){
            int traversalSize = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();
            for(int i = 0; i < traversalSize; i++){
                Node node = queue.poll();
                if(levelToRight)
                    subList.add((Integer) node.data);
                else
                    subList.addFirst((Integer) node.data);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(subList);
            levelToRight =  !levelToRight;
        }
        return  list;
    }

    // Driver method
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.createTree();

//        System.out.println(tree.reverseLevelOrder(tree.getRoot()));
//        System.out.println(tree.zigZagTraversal(tree.getRoot()));
//        System.out.println(tree.minDepthOfBinTree(tree.getRoot()));
//        System.out.println(tree.successor(tree.getRoot(), 11));
//        tree.connectLevelOrderSiblings(tree.getRoot());
//        tree.connectLevelAllOrderSiblings(tree.getRoot());
//        System.out.println(tree.levelAverages(tree.getRoot()));
//        System.out.println(tree.rightView(tree.getRoot()));
//        System.out.println(tree.levelOrder(tree.getRoot()));
        System.out.println(tree.levelOrder(tree.getRoot()));



//        System.out.println("\nRecursive Postorder traversal of binary tree is ");
//        tree.printPostorder(tree.root);
//        System.out.println("\nIterative Postorder traversal of binary tree is ");
//        tree.printPostorderIter(tree.root);

//        System.out.println("\nLevel order traversal of binary tree is ");
//        tree.levelOrderTraversal(tree.root);

//        System.out.println("\nRecursive Inorder traversal of binary tree is ");
//        tree.printInorder(tree.root);
//        System.out.println("\nIterative Inorder traversal of binary tree is ");
//        tree.printInorderIter(tree.root);

//        System.out.println("Recursive Preorder traversal of binary tree is ");
//        tree.printPreorder(tree.root);
//        System.out.println("Iterative Preorder traversal of binary tree is ");
//        tree.printPreorderIter(tree.root);
    }

    private void connectLevelOrderSiblings(Node tree) {
        if(tree == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            Node prev = null;
            for (int i = 0; i < levelSize; i++){
                Node node = queue.poll();
                if(prev != null){
                    prev.next = node;
                }
                if(i == levelSize -1){
                    node.next = null;
                }
                prev= node;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
    }

    private void connectLevelAllOrderSiblings(Node tree) {
        if(tree == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(tree);
        Node prev = null;
        Node node = null;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++){
                node = queue.poll();
                if(prev != null){
                    prev.next = node;
                }
                prev= node;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        node.next = null;
    }

    private List<Double> levelAverages(Node root) {
        List<Double> list = new LinkedList<>();
        if(root == null) return list;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            double sum = 0;
            for(int i = 0; i < levelSize; i++){
                Node node = queue.poll();
                sum += (Integer) node.data;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            list.add((double) sum/levelSize);
        }
        return list;
    }

    public Node getRoot() {
        return root;
    }

    public void createTree() {
        root = new Node(25);
        root.left = new Node(15);
        root.right = new Node(50);
        root.left.left = new Node(10);
        root.left.right = new Node(22);
        root.right.left = new Node(35);
        root.right.right = new Node(70);
        root.right.left.left = new Node(30);
        root.right.left.right = new Node(36);
        root.right.right.left = new Node(60);
        root.right.right.right = new Node(88);
//        root.right.right.right.left = new Node(98);
    }
    public void createSmallTree() {
        root = new Node(1);
        root.left = new Node(7);
        root.right = new Node(9);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        root.right.right = new Node(7);
    }

    protected void printPostorder(Node tree) {
        if(tree == null) return;
        printPostorder(tree.left);
        printPostorder(tree.right);
        System.out.print(tree.data + " ");
    }

    protected void printInorder(Node tree) {
        if(tree == null) return;
        printInorder(tree.left);
        System.out.print(tree.data + " ");
        printInorder(tree.right);
    }

    protected void printPreorder(Node tree) {
        if(tree == null) return;
        System.out.print(tree.data + " ");
        printPreorder(tree.left);
        printPreorder(tree.right);
    }


    public List<List<Integer>> reverseLevelOrder(Node tree){
        List<List<Integer>> list = new LinkedList<>();

        if(tree == null) return list;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(tree);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            ArrayList<Integer> subList = new ArrayList<>(levelSize);
            for(int i = 0; i < levelSize; i++){
                Node node = queue.poll();
                subList.add((Integer) node.data);

                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            list.add(0, subList);
        }
        return list;
    }


    //    public int[][] levelOrder(Node root) {
//        int[][] arr = new int[height(root)][];
////        levelOrder(root, new int[])
//        return arr;
//    }
}


