package com.company.graph.topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {

    /*
    For each vertex "u" in G(V,E)
      mark u as visited
      For each vertex "v" in neighbors of u
          if neighbour not visited
              visit neighbor
      add u to stack        */

    private static Stack<Vertex> stack;

    public TopologicalOrdering() {
        stack = new Stack<>();
    }

    // Called for each vertex
    static void topologicalOrderDFS(Vertex vertex){
        // u comes
        vertex.visited = true;

        // before v
        for(Vertex v : vertex.neighbours){
            if(!v.visited){
                topologicalOrderDFS(v);
            }
        }
        stack.push(vertex);
    }

    public static void main(String[] args) {
        TopologicalOrdering topOrdering = new TopologicalOrdering();
        ArrayList<Vertex> graph = new ArrayList<>();
        createGraph(graph);

        // We consider all of the input items (multiple graphs)
        for (Vertex vertex : graph) {
            // Ordering to be stored in Stack
            if (!vertex.visited) {
                topologicalOrderDFS(vertex);
            }
        }
        // Pop stack to get the order
        while (!topOrdering.stack.isEmpty())
            System.out.print(topOrdering.stack.pop() + " -> ");
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

    private static void createGraph(List<Vertex> graph) {
        graph.add(new Vertex("0")); // blank neighbor linkedlist created
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        graph.get(2).addNeighbours(graph.get(3)); // join vertex 3 with vertex 4
        graph.get(3).addNeighbours(graph.get(1)); // 0 based Idx
        graph.get(4).addNeighbours(graph.get(0));
        graph.get(4).addNeighbours(graph.get(1));
        graph.get(5).addNeighbours(graph.get(0));
        graph.get(5).addNeighbours(graph.get(2));
    }
}
