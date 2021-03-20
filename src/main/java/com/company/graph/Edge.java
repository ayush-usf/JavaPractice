package com.company.graph;

public class Edge {
    public int neighbor;
    public Edge next;

    public Edge(int neighbor) {
        this.neighbor = neighbor;
        this.next = null;
    }

    public Edge(int neighbor, Edge next) {
        this.neighbor = neighbor;
        this.next = next;
    }

    public int getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(int neighbor) {
        this.neighbor = neighbor;
    }

    public Edge getNext() {
        return next;
    }

    public void setNext(Edge next) {
        this.next = next;
    }
}
