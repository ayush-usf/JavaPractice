package com.company.graph;

import java.util.LinkedList;

public class BellmanFord {
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
    static class Vertex{
        String name;
        boolean visited;
        double distance = Double.MAX_VALUE;
        Vertex previousV;
        LinkedList<Edge> edges;
    }
}
