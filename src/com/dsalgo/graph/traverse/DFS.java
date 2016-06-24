package com.dsalgo.graph.traverse;

import com.dsalgo.graph.Vertex;
import com.dsalgo.graph.util.GraphUtil;

public class DFS {

    public static void main(String[] args) {
        Vertex[] adjacencyList = GraphUtil.setUpVertex(6);
        dfs(adjacencyList);
    }

    private static void dfs(Vertex[] adjacencyList) {
        doDfs(adjacencyList[1]);
    }

    private static void doDfs(Vertex current) {
        System.out.println("Node found in dfs : " + current.getName());
        current.setVisited();
        Vertex[] destinations = current.getOuts();
        for (Vertex v : destinations) {
            if (v != null && !v.isVisited()) {
                doDfs(v);
            }
        }
    }

}
