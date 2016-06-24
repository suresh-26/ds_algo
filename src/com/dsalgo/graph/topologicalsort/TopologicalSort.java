package com.dsalgo.graph.topologicalsort;

import java.util.Stack;

import com.dsalgo.graph.Vertex;
import com.dsalgo.graph.util.GraphUtil;

public class TopologicalSort {

    public Stack getStk() {
        return stk;
    }

    public void setStk(Stack stk) {
        this.stk = stk;
    }

    Stack stk;
    Vertex[] stkArray;
    int c;
    static boolean[] isViisitedBySameLoop;

    public TopologicalSort() {
        stk = new Stack();
        c = 1;
    }

    void dfs(Vertex v) {
        System.out.println("Visiting " + v.getName());
        // mark v visited
        v.setVisited();
        // get the number of OUT(V)
        int numouts = v.getOutsNum();

        // copies v.getOuts(i), the out vertices of v, to a temporary array outs[i]
        Vertex[] outs = new Vertex[numouts + 1];
        for (int i = 1; i <= numouts; i++)
            outs[i] = v.getOutsFromIndex(i);
        // for each w in OUT(v) do
        for (int i = 1; i <= numouts; i++) {
            Vertex w = outs[i];
            System.out.println(v.getName() + " now looks at " + w.getName());

            // if w is unvisited then dfs(w)
            // if(!w.isVisited()) {
            System.out.println("recurrsively visiting nodes: " + w.getName());
            dfs(w);
            // }
        }
        // push(v) into STACK

        if (stk.contains(v) && v.isVisited()) {
            System.out.println("graph is not cyclic, topological sort not possible " + v.getName());
            // System.exit(0);
        } else {
            stk.push(v);
            System.out.println("STACK: " + v.getName() + " pushed");
        }
    }

    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort();
        int numVertex = 6;
        Vertex[] V = GraphUtil.setUpVertex(numVertex);

        // while there is an "unvisited" v do dfs(v)
        int i = 0;
        while (i < numVertex) {
            for (i = 1; i <= numVertex; i++) {
                isViisitedBySameLoop[i - 1] = true;
                if (!V[i].isVisited()) {
                    ts.dfs(V[i]);
                }
                isViisitedBySameLoop[i - 1] = false;
            }
        }
        // pop() until STACK=empty and write
        i = 0;
        while (i < numVertex) {
            Vertex v = (Vertex) ts.getStk().pop();
            i++;
            System.out.println("Pops out " + v.getName() + " ");
        }

        System.out.flush();

    }
}
