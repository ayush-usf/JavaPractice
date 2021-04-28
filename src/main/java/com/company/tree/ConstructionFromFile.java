package com.company.tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructionFromFile {

    static class Node{
        String data;
        Node[] children;

        public Node(String data) {
            this.data = data;
            this.children = null;
        }

        public Node(String data, int size) {
            this.data = data;
            this.children = new Node[size];
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, ArrayList<String>> nodeChildrenMap = new HashMap<>();
        String root = readFileNGetRoot(nodeChildrenMap);
        System.out.println("root = " + root);
        Queue<Node> parentQueue = new LinkedList<>();
        Node rootNode = null;
        if(root != null) {
            rootNode = new Node(root);
            if (nodeChildrenMap.size() > 0) {
                addChildrenNodes(root, nodeChildrenMap, parentQueue, rootNode);
                while (!parentQueue.isEmpty()) {
                    Node parentNode = parentQueue.poll();
                    addChildrenNodes(parentNode.data, nodeChildrenMap, parentQueue, parentNode);
                }
            }
        }
        printTree(rootNode);

    }

    private static void printTree(Node tree) {
        if(tree == null) return;
        System.out.print(tree.data + " ");
        if(tree.children != null){
            for(int i = 0; i < tree.children.length; i++)
                printTree(tree.children[i]);
        }
    }

    private static void addChildrenNodes(String root, HashMap<String, ArrayList<String>> nodeChildrenMap,
                                         Queue<Node> parentQueue, Node parentNode) {

        ArrayList<String> children = nodeChildrenMap.get(root);
        if(children.size() > 0){
            Node[] nodes = new Node[children.size()];
            for(int i = 0; i < children.size(); i++){
                String nodeName = children.get(i);
                nodes[i] = new Node(nodeName);
                if(nodeChildrenMap.containsKey(nodeName))
                    parentQueue.offer(nodes[i]);
            }
            parentNode.children = nodes;
        }
    }

    private static String readFileNGetRoot(HashMap<String, ArrayList<String>> nodeChildrenMap) {
        String root = null;
        try(BufferedReader br = new BufferedReader(new FileReader("input/tree_nodes.txt"))){
        String line;
        int counter = 0;
            while ((line= br.readLine()) != null){
                if(line.length() > 0) {
                    String[] reg = line.split(" ");
                    ArrayList<String> list = new ArrayList<>();
                    String parent = null;
                    for (int i = 0; i < reg.length; i++) {
                        if (i == 0) {
                            parent = reg[i];
                        } else {
                            list.add(reg[i]);
                        }

                    }
                    if(counter++ == 0){
                        root = parent;
                    }
                    if(parent != null && list.size() > 0)
                        nodeChildrenMap.put(parent, list);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return root;
    }
}
