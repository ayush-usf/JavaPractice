package com.company.graph.topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalOrderingVisitedArr {

    private Stack<Vertex> stack;

    public TopologicalOrderingVisitedArr() {
        this.stack = new Stack<>();
    }

    static class Vertex{
        String label;
        boolean visited;
        List<Vertex> neighbours;

        public Vertex(String label) {
            this.label = label;
            this.neighbours = new LinkedList<>();
        }

        void addNeighbours(Vertex vertex){
            this.neighbours.add(vertex);
        }

        @Override
        public String toString() {
            return this.label;
        }
    }

    void dfs(Vertex vertex){
        vertex.visited = true;
        for(Vertex v : vertex.neighbours){
            if(!v.visited){
                dfs(v);
            }
        }
        stack.push(vertex);
    }

    public static void main(String[] args) {
        TopologicalOrderingVisitedArr ordering = new TopologicalOrderingVisitedArr();
        List<Vertex> graph = new ArrayList<>();
        createGraph(graph);

        for (int i = 0; i < graph.size(); i++) {
            // We consider all of the input items
            // If Weakly connected components
            if (!graph.get(i).visited) {
                ordering.dfs(graph.get(i));
            }
        }
        while (!ordering.stack.isEmpty())
            System.out.print(ordering.stack.pop() + " -> ");
    }

    private static void createGraph(List<Vertex> graph) {
        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));

        graph.add(new Vertex("5"));
        graph.get(2).addNeighbours(graph.get(3));
        graph.get(3).addNeighbours(graph.get(1));
        graph.get(4).addNeighbours(graph.get(0));
        graph.get(4).addNeighbours(graph.get(1));
        graph.get(5).addNeighbours(graph.get(0));
        graph.get(5).addNeighbours(graph.get(2));
    }
}
