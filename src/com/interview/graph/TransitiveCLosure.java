package com.interview.graph;

// Only applicable for Directed Graph
// Graph G: A → B → C

//From A you can reach B directly, and C through B.
//From B you can reach C.

//Transitive Closure G*:
//A → B
//A → C
//B → C

public class TransitiveCLosure {

    public static void transitiveClosure(int V, int graph[][]) {
        int reach[][] = new int[V][V];
        int  i, j, k;

        for (i = 0; i < V; i++)         //initlize solution matrix same as graph matrix
            for (j = 0; j < V; j++)
                reach[i][j] = graph[i][j];

        for (k = 0; k < V; k++) {       // Pick all vertices as source one by one
            for (i = 0; i < V; i++) {       // Pick all vertices as destination for the above picked source
                for (j = 0; j < V; j++) {       // If vertex k is on a path from i to j, then make sure that the value of reach[i][j] is 1
                    reach[i][j] = (reach[i][j]==1) || ((reach[i][k]==1) && (reach[k][j]==1)) ? 1 : 0;
                }
            }
        }

        printSolution(reach, V);
    }

    private static void printSolution(int reach[][], int V) {
        System.out.println("Following matrix is transitive closure"+
                " of the given graph");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if ( i == j)
                    System.out.print("1 ");
                else
                    System.out.print(reach[i][j]+" ");
            }
            System.out.println();
        }
    }
}
