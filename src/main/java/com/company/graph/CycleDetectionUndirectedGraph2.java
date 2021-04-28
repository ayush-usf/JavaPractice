package com.company.graph;

import java.util.LinkedList;

import java.util.*;

class CycleDetectionUndirectedGraph2 {

    private final LinkedList<Integer>[] adj; // Adjacency List Representation

    CycleDetectionUndirectedGraph2(int vertexCnt) {
        adj = new LinkedList[vertexCnt];

        for(int i = 0; i < vertexCnt; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v,int w) {
        adj[v].add(w);
        adj[w].add(v); // undirected graph
    }

    // Returns true if the graph contains a cycle, else false.
    boolean isCyclic(int size) {

        boolean[] visited = new boolean[size];

        for (int vertexIdx = 0; vertexIdx < size; vertexIdx++) {
            // parent for starting node = -1
            if (!visited[vertexIdx] && isCyclic(vertexIdx, visited, -1))
                    return true;
        }
        return false;
    }

    // A recursive function that uses visited[] and parent to
    // detect cycle in subgraph reachable from vertex v.

    boolean isCyclic(int vertexIdx, boolean[] visited, int parent) {
        visited[vertexIdx] = true;

        for(Integer i: adj[vertexIdx]) {

            if (!visited[i] && isCyclic(i, visited, vertexIdx))
                    return true;
            // If an adjacent is visited and not parent of
            // current vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }

    public static void main(String args[]) {

        CycleDetectionUndirectedGraph2 g1 = new CycleDetectionUndirectedGraph2(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic(5))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        CycleDetectionUndirectedGraph2 g2 = new CycleDetectionUndirectedGraph2(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic(3))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }
}
//public class CycleDetectionGraph2 {
//
//    private LinkedList<Vertex>[] vertices;
//    private boolean[] visited;
//
//    public CycleDetectionGraph2(int size) {
//        this.vertices = new LinkedList[size];
//        this.visited = new boolean[size];
//    }
//
//    static class Vertex{
//        private Object data;
//        private Vertex next;
//    }
//
//    public static void main(String[] args) {
//        CycleDetectionGraph2 graph = new CycleDetectionGraph2(3);
//        detectCycle(graph.vertices, graph.beingVisited, graph.visited);

//    }
//    static void detectCycle(Vertex[] vertices,boolean[] beingVisited,boolean[] visited){
//        for(Vertex v : vertices){
//            if(!visited[v.idx])
//                dfs(vertices, v.idx, beingVisited, visited);
//        }
//    }
//
//    private static void dfs(Vertex[] vertices, int startVIdx, boolean[] beingVisited, boolean[] visited) {
//        beingVisited[startVIdx] = true;
//
//        for(Vertex v = vertices[startVIdx]; v != null ; v=v.next){
//            if(beingVisited[v.idx]){
//                System.out.println("Cycle : Backward edge at "+ v.idx + " with data " + v.data);
//                return;
//            }
//
//            if(!visited[v.idx]){
//                visited[v.idx] = true;
//                dfs(vertices, v.idx, beingVisited, visited);
//            }
//        }
//        beingVisited[startVIdx] = false;
//        visited[startVIdx] = true;
//    }

//    static class Vertex{
//        private String data;
//        private int idx;
//        private boolean beingVisited;
//        private boolean visited;
//        private Vertex next;
//    }

//}
