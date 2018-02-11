package com.dsalgo.tree.bfs;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public int data;
    private List<Node> nodes = new ArrayList<>();
    private boolean visited;

    public Node(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (null == nodes) {
            nodes = new ArrayList<>();
        }
        this.nodes.add(newNode);
    }

}
