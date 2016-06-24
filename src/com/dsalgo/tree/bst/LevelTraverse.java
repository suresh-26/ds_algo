package com.dsalgo.tree.bst;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraverse {
    public static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) {
        Tree tree = loadTree();
        bfs(tree);
    }

    private static void bfs(Tree tree) {
        tree.root.setVisited(false);
        doBfs(tree.root);
    }

    private static void doBfs(Node current) {
        System.out.println("Visited node, in BFS: " + current.getData());
        List<Node> destinations = current.getNodes();
        for (Node node : destinations) {
            if (node != null && !node.isVisited()) {
                node.setVisited(true);
                queue.add(node);
            }
        }
        if (!queue.isEmpty())
            doBfs(queue.poll());
    }

    private static Tree loadTree() {
        Tree tree = new Tree(1);
        tree.root.addNode(2);
        tree.root.addNode(3);
        tree.root.addNode(4);
        tree.root.getNodes().get(0).addNode(5);
        tree.root.getNodes().get(0).addNode(6);
        tree.root.getNodes().get(0).addNode(7);
        tree.root.getNodes().get(1).addNode(8);
        tree.root.getNodes().get(2).addNode(9);
        tree.root.getNodes().get(2).addNode(10);
        return tree;
    }

}
