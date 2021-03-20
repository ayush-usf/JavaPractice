package com.company.graph.disjointsets;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    
    int setCount = 0;
    List<DisjointSet.Node> representativesList;

    class Node{
        int id;
        int rank;
        Node parent;

        public Node(int id, int rank, DisjointSet.Node parent) {
            this.id = id;
            this.rank = rank;
            this.parent = parent;
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

    public DisjointSet(List<Vertex> vertices) {
        this.representativesList = new ArrayList<>(vertices.size());
        for(int i = 0; i < vertices.size(); i++)
            makeSet(vertices.get(i), i);
    }

    private void makeSet(Vertex vertex, int id) {
        int rank = 0;
        DisjointSet.Node parent = null;
        Node n = new Node(id, rank, parent);
        vertex.node = n;
        this.representativesList.add(n);
        this.setCount++;
    }

    public int findRepr(DisjointSet.Node n){
        DisjointSet.Node temp = n;

        // Getting the representative of the node
        while (temp.parent != null){
            temp = temp.parent;     // After Path compression, this will not be very long.
        }

        // Path compression
        DisjointSet.Node representative = temp;
        temp = n;                   // reset

        // path compression for each node under representative
        // (iterative implementation)
        while (temp != representative){
            DisjointSet.Node temp2 = temp.parent;
            temp.parent = representative;
            temp = temp2;
        }
        return representative.id;
    }

    void unionNDetectCycle(DisjointSet.Node node1, DisjointSet.Node node2){
        // At the end, it will become 1 set
        int idx1 = findRepr(node1);
        int idx2 = findRepr(node2);

        // If both nodes in same set
        // Cycle detected
        if(idx1 == idx2) {
            System.out.println("Cycle found:");
            return;
        }

        DisjointSet.Node repr1 = this.representativesList.get(idx1);
        DisjointSet.Node repr2 = this.representativesList.get(idx2);

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
