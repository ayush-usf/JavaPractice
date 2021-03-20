package com.company.graph;

import java.util.LinkedList;

public class Graph {


    public static void main(String[] args) {
//        Edge[] graph = new Edge[10];
        Vertex a = new Vertex("A", 0);
        Vertex b = new Vertex("B", 1);
        Vertex c = new Vertex("C", 2);
        Vertex d = new Vertex("D", 3);
        a.addNeighbour(b);
        a.addNeighbour(c);
        b.addNeighbour(d);

        a.showNeighbours();
        b.showNeighbours();
        c.showNeighbours();
        d.showNeighbours();
    }
}
