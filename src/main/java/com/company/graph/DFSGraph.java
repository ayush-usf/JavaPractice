package com.company.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSGraph {
    Vertex[] vertices;
    boolean[] visited;

    public DFSGraph(int vertexCnt) {
        vertices = new Vertex[vertexCnt];
        visited = new boolean[vertexCnt];
    }

    static class Vertex{
        int idx;
        String data;
        Vertex next;
    }

    public static void main(String[] args) {
        DFSGraph g = new DFSGraph(3);
//        Vertex v1 = new Vertex(3);
        Vertex[] vertices = new Vertex[10];
//        graph.addEdge(v1, v2);

        // recur.
        // For weakly connected graph
        for(Vertex v: vertices) {
            graph_dfs_stack(g.vertices, v.idx, g.visited);
        }
    }

    // stack - same as bfs, stack replaced by queue
    private static void graph_dfs_stack(Vertex[] vertices, int currVIdx, boolean[] visited) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(vertices[currVIdx]);

        visited[currVIdx] = true;

        while (!stack.isEmpty()){
            Vertex vertex = stack.pop();
            System.out.print(vertex.data + " ");

            for(Vertex v = vertices[vertex.idx]; v != null; v = v.next){
                if(!visited[v.idx]){
                    visited[v.idx] = true;
                    stack.push(v);
                }
            }
        }
    }


    static void graph_bfs(Vertex[] vertices, int currVIdx, boolean[] visited){
        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(vertices[currVIdx]);

        visited[currVIdx] = true;

        while (!queue.isEmpty()){
            Vertex vertex = queue.poll();

            for(Vertex v = vertices[vertex.idx]; v != null; v = v.next){
                if(!visited[v.idx]){
                    visited[v.idx] = true;
                    queue.offer(v);
                }
            }
        }
    }


    static void graph_dfs(Vertex[] vertices, int currVIdx, boolean[] visited){
        visited[currVIdx] = true;
        for(Vertex v = vertices[currVIdx]; v != null; v = v.next){
            int nextIdx = v.idx;
            if(!visited[nextIdx]){
                graph_dfs(vertices, nextIdx, visited);
            }
        }
    }


//    static void dfs(Vertex[] graph, int currVertexIdx, boolean[] visited){
//
//        visited[currVertexIdx] = true;
//
//        for(Vertex temp = graph[currVertexIdx]; temp != null; temp = temp.next){
//            if(!visited[temp.data]){  // temp.data represents neighbour
//                dfs(graph, temp.data, visited);
//            }
//        }
//    }
}
