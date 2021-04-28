package com.company.graph;

public class CycleDetectionGraph {

    private Vertex[] vertices;
    private boolean[] beingVisited;
    private boolean[] visited;

    public CycleDetectionGraph(int size) {
        this.vertices = new Vertex[size];
        this.beingVisited = new boolean[size];
        this.visited = new boolean[size];
    }

    static class Vertex{
        private String data;
        private int idx;
        private Vertex next;
    }

    public static void main(String[] args) {
        CycleDetectionGraph graph = new CycleDetectionGraph(3);
        detectCycle(graph.vertices, graph.beingVisited, graph.visited);

    }
    static void detectCycle(Vertex[] vertices,boolean[] beingVisited,boolean[] visited){
        for(Vertex v : vertices){
            if(!visited[v.idx])
                dfs(vertices, v.idx, beingVisited, visited);
        }
    }

    private static void dfs(Vertex[] vertices, int startVIdx, boolean[] beingVisited, boolean[] visited) {
        beingVisited[startVIdx] = true;

        for(Vertex v = vertices[startVIdx]; v != null ; v=v.next){
            if(beingVisited[v.idx]){
                System.out.println("Cycle : Backward edge at "+ v.idx + " with data " + v.data);
                return;
            }

            if(!visited[v.idx]){
                visited[v.idx] = true;
                dfs(vertices, v.idx, beingVisited, visited);
            }
        }
        beingVisited[startVIdx] = false;
        visited[startVIdx] = true;
    }

//    static class Vertex{
//        private String data;
//        private int idx;
//        private boolean beingVisited;
//        private boolean visited;
//        private Vertex next;
//    }

}
