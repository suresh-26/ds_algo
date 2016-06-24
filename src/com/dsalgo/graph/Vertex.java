package com.dsalgo.graph;

public class Vertex {
    char name;
    Vertex[] Outs;
    int numOfDestinationVertices;
    boolean visited = false;

    public Vertex(char v) {
        name = v;
        numOfDestinationVertices = 0;
        Outs = new Vertex[100];
    }

    public char getName() {
        return name;
    }

    public void setOuts(Vertex v) {
        numOfDestinationVertices++;
        Outs[numOfDestinationVertices] = v;
    }

    public int getOutsNum() {
        return numOfDestinationVertices;
    }

    public Vertex[] getOuts() {
        return Outs;
    }

    public Vertex getOutsFromIndex(int i) {
        return Outs[i];
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    int N;
    int L;

    public void setL(int v) {
        L = v;
    }

    public void setN(int v) {
        N = v;
    }

    public int getL() {
        return L;
    }

    public int getN() {
        return N;
    }

    public void display() {
        System.out.print(name);
        System.out.println("  N:" + N + " L:" + L);
    }

}
