package com.dsalgo.graph.traverse;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.dsalgo.graph.Vertex;
import com.dsalgo.graph.util.GraphUtil;

public class BFS {
    public static Queue<Vertex> queue = new LinkedList<>();

    public static void main(String[] args) {
        Vertex[] adjacencyList = GraphUtil.setUpVertex(6);
        // bfs(adjacencyList);
        System.out.println("shortes path: " + shortestPathUsingBFS(adjacencyList[1], adjacencyList[5]));
    }

    private static void bfs(Vertex[] adjacencyList) {
        adjacencyList[1].setVisited();
        doBfs(adjacencyList[1]);
    }

    private static void doBfs(Vertex current) {
        System.out.println("Visited node, in BFS: " + current.getName());
        // current.setVisited();
        Vertex[] destinations = current.getOuts();
        for (Vertex v : destinations) {
            if (v != null && !v.isVisited()) {
                v.setVisited();
                queue.add(v);
            }
        }
        if (!queue.isEmpty())
            doBfs(queue.poll());
    }

    private static int shortestPathUsingBFS(Vertex source, Vertex destination) {
        int shortestDis = 0;
        int currentDis = 0;
        Vertex[] shortestPath = new Vertex[7];
        Vertex[] currentPath = new Vertex[7];
        currentPath[0] = source;
        queue.add(source);
        while (!queue.isEmpty()) {

            Vertex current = queue.poll();

            Vertex[] destinations = current.getOuts();
            for (Vertex v : destinations) {
                if (v != null && !v.isVisited()) {
                    v.setVisited();
                    currentDis++;
                    currentPath[currentDis] = v;
                    queue.add(v);
                    if (v.getName() == destination.getName() && shortestDis < currentDis) {
                        shortestDis = currentDis;
                        shortestPath = Arrays.copyOf(currentPath, 7);
                        break;
                    }
                }
            }

        }
        Arrays.stream(shortestPath).filter(v -> v != null).map(v -> v.getName()).forEach(System.out::println);
        return shortestDis;
    }

}
