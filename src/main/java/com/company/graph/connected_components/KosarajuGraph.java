package com.company.graph.connected_components;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KosarajuGraph {

    List<Vertex> vertices;
    List<Edge> edges;

    public KosarajuGraph() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    static class Vertex{
        int id;
        String label;
        boolean visited;
        LinkedList<Vertex> neighbours;
        int componentId;

        public Vertex(int id, String label) {
            this.id = id;
            this.label = label;
            this.neighbours = new LinkedList<>();
        }

        void addNeighbour(Vertex v){
            this.neighbours.add(v);
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

    KosarajuGraph getTranspose(){
        KosarajuGraph transposed = new KosarajuGraph();

        List<Vertex> transposedVertices = new ArrayList<>();

        for(Vertex vertex: this.vertices){
            transposedVertices.add(vertex);
        }

        for (Edge edge : this.edges){
            transposedVertices.get(transposedVertices.indexOf(edge.destVertex)).addNeighbour(edge.startVertex);
        }

        transposed.vertices = transposedVertices;

        return  transposed;
    }
}
