package com.company.graph.disjointsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskals {

    class DisjointSet{

//        int nodeCount = 0;
        int setCount = 0;
        List<Node> reprList;

        class Node{
            int id;
            int rank;
            Node parent;

            public Node(int id, int rank, Node parent) {
                this.id = id;
                this.rank = rank;
                this.parent = parent;
            }
        }

        public DisjointSet(List<Vertex> vertices) {
            this.reprList = new ArrayList<>(vertices.size());
            for(int i = 0; i < vertices.size(); i++)
                makeSet(vertices.get(i), i);
        }

        private void makeSet(Vertex vertex, int id) {
            int rank = 0;
            Node parent = null;
            Node n = new Node(id, rank, parent);
            vertex.node = n;
            this.reprList.add(n);
            this.setCount++;
//            this.nodeCount++;
        }

        public int findRepr(Node n){
            Node temp = n;

            // Getting the representative of the node
            while (temp.parent != null){
                temp = temp.parent;     // After Path compression, this will not be very long.
            }

            // Path compression
            Node representative = temp;
            temp = n;                   // reset

            // path compression for each node under representative
            // (iterative implementation)
            while (temp != representative){
                Node temp2 = temp.parent;
                temp.parent = representative;
                temp = temp2;
            }
            return representative.id;
        }

        void union(Node node1, Node node2){
            // At the end, it will become 1 set
            int idx1 = findRepr(node1);
            int idx2 = findRepr(node2);

            // If both nodes in same set
            // Cycle detected
            if(idx1 == idx2) return;

            Node repr1 = this.reprList.get(idx1);
            Node repr2 = this.reprList.get(idx2);

            // union by rank
            if(repr1.rank < repr2.rank)
                repr1.parent = repr2;
            else if(repr1.rank > repr2.rank)
                repr2.parent = repr1;
            else {
                repr2.parent = repr1;
                repr1.rank++;
            }
            this.setCount--; // as 2 disjoint sets have been merged
        }
    }

    // A vertex is part of a set
    static class Vertex{
        String label;
        DisjointSet.Node node;

        public Vertex(String label) {
            this.label = label;
        }
        @Override
        public String toString() {
            return label;
        }
    }
    static class Edge{
        double weight;
        Vertex startVertex;
        Vertex destVertex;

        public Edge(double weight, Vertex startVertex, Vertex destVertex) {
            this.weight = weight;
            this.startVertex = startVertex;
            this.destVertex = destVertex;
        }
    }

    void spanningTree(List<Vertex> vertices, List<Edge> edges){
        Collections.sort(edges, Comparator.comparingDouble(edge-> edge.weight));
        DisjointSet disjointSet = new DisjointSet(vertices);
        List<Edge> mst = new ArrayList<>();

        // working with edge in ascending order
        // We will check weather adding this edge creates a cycle or not
        for(Edge edge: edges){
            // Start vertex
            Vertex u = edge.startVertex;
            Vertex v = edge.destVertex;

            if(disjointSet.findRepr(u.node) == disjointSet.findRepr(v.node))
                continue;

            mst.add(edge);
            disjointSet.union(u.node, v.node);
        }
        for(Edge edge: mst){
            System.out.print(edge.startVertex +" "+ edge.destVertex + " -- ");
        }
    }
    public static void main(String[] args) {

        List<Vertex> vertices = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(vertices,edges);

        Kruskals kruskals = new Kruskals();
        kruskals.spanningTree(vertices, edges);
    }

    private static void createGraph(List<Vertex> vertices, List<Edge> edges) {
        
        vertices.add(new Vertex("A"));
        vertices.add(new Vertex("B"));
        vertices.add(new Vertex("C"));
        vertices.add(new Vertex("D"));
        vertices.add(new Vertex("E"));
        vertices.add(new Vertex("F"));
        vertices.add(new Vertex("G"));
        vertices.add(new Vertex("H"));

        edges.add(new Edge(3, vertices.get(0), vertices.get(1)));
        edges.add(new Edge(2, vertices.get(0), vertices.get(2)));
        edges.add(new Edge(5, vertices.get(0), vertices.get(3)));
        edges.add(new Edge(13, vertices.get(1), vertices.get(5)));
        edges.add(new Edge(2, vertices.get(1), vertices.get(3)));
        edges.add(new Edge(5, vertices.get(2), vertices.get(4)));
        edges.add(new Edge(2, vertices.get(2), vertices.get(3)));
        edges.add(new Edge(4, vertices.get(3), vertices.get(4)));
        edges.add(new Edge(6, vertices.get(3), vertices.get(5)));
        edges.add(new Edge(3, vertices.get(3), vertices.get(6)));
        edges.add(new Edge(6, vertices.get(4), vertices.get(6)));
        edges.add(new Edge(2, vertices.get(5), vertices.get(6)));
        edges.add(new Edge(3, vertices.get(5), vertices.get(7)));
        edges.add(new Edge(6, vertices.get(6), vertices.get(7)));
    }
}
