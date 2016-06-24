package com.dsalgo.graph.util;

import com.dsalgo.graph.Vertex;

public class GraphUtil {
    public static Vertex[] setUpVertex(int numVertex) {
        ////////////////////////////////////////
        // GRAPH LOADING START
        ////////////////////////////////////////

        Vertex[] V = new Vertex[numVertex + 1];

        V[1] = new Vertex('1');
        V[2] = new Vertex('2');
        V[3] = new Vertex('3');
        V[4] = new Vertex('4');
        V[5] = new Vertex('5');
        V[6] = new Vertex('6');

        // 1-> 2,3
        V[1].setOuts(V[3]);
        V[1].setOuts(V[2]);
        // V[1].setOuts(V[4]);

        // 2->3,4
        V[2].setOuts(V[4]);
        V[2].setOuts(V[3]);

        // 3->5
        V[3].setOuts(V[5]);
        // V[3].setOuts(V[2]);

        // 4->6
        V[4].setOuts(V[5]);
        V[4].setOuts(V[6]);
        // 5->4,6
        // V[5].setOuts(V[6]);
        // V[5].setOuts(V[4]);
        V[5].setOuts(V[6]);
        V[5].setOuts(V[4]);
        // V[6].setOuts(V[1]);
        // V[6].setOuts(V[2]);

        // V[5].setOuts(V[3]);

        //////////////////////////////////////////
        // GRAPH LOADING END
        //////////////////////////////////////////

        // Check if the graph is correctly loaded
        System.out.println("graph representaion");
        for (int i = 1; i <= numVertex; i++) {
            System.out.print(V[i].getName() + "=>");
            for (int j = 1; j <= V[i].getOutsNum(); j++) {
                System.out.print(V[i].getOutsFromIndex(j).getName() + ",");
            }
            System.out.println();
        }

        return V;
    }
}
