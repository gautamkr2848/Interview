package com.interview.graph;

import java.util.ArrayList;
import java.util.List;

/*
For Input:
5 7
0 1
0 4
1 2
1 3
1 4
2 3
3 4

Your Output:
0 -> [1, 4]
1 -> [0, 2, 3, 4]
2 -> [1, 3]
3 -> [1, 2, 4]
4 -> [0, 1, 3]
5 -> [7]
6 -> []
7 -> [5]
*/

public class PrintAdjacency {

    public static void printGraph() {

        int[][] edges = {{5, 7},
                {0, 1},
                {0, 4},
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 3},
                {3,4}};
        int V = edges.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<V;i++)
            ans.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            ans.get(edges[i][0]).add(edges[i][1]);
            ans.get(edges[i][1]).add(edges[i][0]);
        }

        int i=0;
        for(List<Integer> list : ans) {
            System.out.println(i++ + " -> " +list.toString());
        }
    }

    public static void main(String[] args) {
        printGraph();
    }
}
