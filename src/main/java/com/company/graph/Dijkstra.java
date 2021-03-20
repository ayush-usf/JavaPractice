package com.company.graph;

import java.util.*;

public class Dijkstra {

    static class Vertex{
        String label;
        LinkedList<Edge> edges;
        boolean visited;
        Vertex predecessor;
        double distance;

        public Vertex(String label) {
            this.label = label;
            this.edges = new LinkedList<>();
            this.distance = Double.MAX_VALUE;
        }

        public void addNeighbor(Edge edge){
            this.edges.add(edge);
        }

        @Override
        public String toString() {
            return this.label;
        }
    }

    static class Edge{
        double weight;
        Vertex startVertex;
        Vertex targetVertex;

        public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
            this.weight = weight;
            this.startVertex = startVertex;
            this.targetVertex = targetVertex;
        }
        public Edge(double weight, Vertex targetVertex) {
            this.weight = weight;
            this.targetVertex = targetVertex;
        }
    }

    public void computePaths(Vertex sourceVertex){
        // distance of sourceVertex to sourceVertex
        sourceVertex.distance = 0;
        PriorityQueue<Vertex> pQueue = new PriorityQueue<>(Comparator.comparingDouble(vertex -> vertex.distance));
        pQueue.offer(sourceVertex);

        while (!pQueue.isEmpty()){
            Vertex tempSrcVertex = pQueue.poll();

            for(Edge edge: tempSrcVertex.edges){
                Vertex adjVertex = edge.targetVertex;
                // distance from src to adjVertex
                double dist = tempSrcVertex.distance + edge.weight;
                if(dist < adjVertex.distance){
                    pQueue.remove(adjVertex);
                    // Update and add
                    adjVertex.distance = dist;
                    adjVertex.predecessor = tempSrcVertex;
                    pQueue.add(adjVertex);
                }
            }
        }
    }

    public List<Vertex> getShortPathToVert (Vertex destVertex){
        List<Vertex> shortestPathVertices = new ArrayList<>();
        for(Vertex v = destVertex; v!= null; v = v.predecessor){
            // backtrack
            shortestPathVertices.add(v);
        }
        Collections.reverse(shortestPathVertices);
        return shortestPathVertices;
    }

    public static void main(String[] args) {
        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");

        v0.addNeighbor(new Edge(1, v0, v1));
        v0.addNeighbor(new Edge(1, v0, v2));
        v1.addNeighbor(new Edge(1, v1, v2));

        Dijkstra algorithm = new Dijkstra();
        algorithm.computePaths(v0);
        System.out.println(algorithm.getShortPathToVert(v2));
    }

}
