package com.company.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

// Adjacency List
public class Vertex {
//    private HashMap<String,Integer> labelVNo;
    private String label;
    private int vertexNo;
    private LinkedList<Vertex> adjacencyList;

    public Vertex(String label, int vertexNo) {
        this.label = label;
        this.vertexNo = vertexNo;
        this.adjacencyList = new LinkedList<>();
    }

    public void addNeighbour(Vertex v){
        this.adjacencyList.add(v);
    }

    public void showNeighbours(){
        System.out.print("\tNeighbours of "+ label + " : ");
        if(adjacencyList.size() > 0) {
            System.out.print("[ ");
            Iterator<Vertex> it = adjacencyList.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.print("]");
        }
        else {
            System.out.print("[]");
        }
    }

    @Override
    public String toString() {
        return "" +label;
    }
}
