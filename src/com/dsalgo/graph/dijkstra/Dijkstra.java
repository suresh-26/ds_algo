package com.dsalgo.graph.dijkstra;

import java.io.File;
import java.util.Scanner;


/**
 * @author suresh.gupta
 *
 */
public class Dijkstra {

    static int[][] cost;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("D:/dijkstraData.txt"));
        int n =200;
        cost = new int[n][n];
        dist = new int[n];
        
        //initializing cost array with a[i][i] as 0 and rest as 99999..i.e. all self loops are 0. 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    cost[i][j] = 0;
                } else {
                    cost[i][j] = 99999;
                }
            }
        }
        
        //initializing the adjacency matrix with given adjacency list
        //considering vertex at their position - 1 index..i.e. first vertex will be at 0th index, likewise 80th vertex will occur at 79th index. Thats where v-1 has come.
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split("\t");
            int v = Integer.parseInt(s[0]);
            for (int j = 1; j < s.length; j++) {
                String[] ls = s[j].split(",");
                cost[v - 1][Integer.parseInt(ls[0]) - 1] = Integer.parseInt(ls[1]);
            }
        }

           shortestPath(0,n);
     
        for (int i = 0; i < n; i++) {//7,37,59,82,99,115,133,165,188,197.
           
            switch (i + 1) {
                case 7: System.out.print(dist[i] + ",");
                    break;
                case 37: System.out.print(dist[i] + ",");
                    break;
                case 59: System.out.print(dist[i] + ",");
                    break;
                case 82: System.out.print(dist[i] + ",");
                    break;
                case 99: System.out.print(dist[i] + ",");
                    break;
                case 115: System.out.print(dist[i] + ",");
                    break;
                case 133: System.out.print(dist[i] + ",");
                    break;
                case 165: System.out.print(dist[i] + ",");
                    break;
                case 188: System.out.print(dist[i] + ",");
                    break;
                case 197: System.out.print(dist[i]);
                    break;



            }
        }


    }

    static void shortestPath(int v, int n) {
        //to identify whether vertex has been visited
    	int[] s = new int[n];
    	
    	//make alll vertices visited
    	//add direct paths of each vertices into dist
        for (int i = 0; i < n; i++) {
            s[i] = 0;
            dist[i] = cost[v][i];
        }
        
        //make source vertex 0 as explored
        //dist[0] also as 0, as we need to store distances from 0 to all nodes.
        s[v] = 1;
        dist[v] = 0;
        for (int i = 1; i < n - 1; i++) {
            int u = 0, dis = 0;
            for (int j = 0; j < s.length; j++) {
                if (s[j] == 0) {
                    dis = dist[j];
                    u = j;
                    for (int k = j + 1; k < s.length; k++) {

                        if (dis > dist[k] && s[k] == 0) {
                            dis = dist[k];
                            u = k;
                        }
                    }
                    break;
                }

            }
            s[u] = 1;
            for (int j = 1; j < n; j++) {
                if (s[j] == 0) {
                    if (dist[j] > (dist[u] + cost[u][j])) {
                        dist[j] = dist[u] + cost[u][j];

                    }
                }
            }
        }

    }
}
