package com.interview.matrix;

public class MinCostPath {

    public void minCostPath(){
        int cost[][]= {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
        int tc[][]=new int[3][3];

        tc[0][0] = cost[0][0];

        /* Initialize first column of total cost(tc) array */
        for (int i = 1; i <= 3; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];

        /* Initialize first row of tc array */
        for (int j = 1; j <= 3; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];

        /* Construct rest of the tc array */
        for (int i = 1; i <= 3; i++)
            for (int j = 1; j <= 3; j++)
                tc[i][j] = min(tc[i-1][j-1], tc[i-1][j], tc[i][j-1]) + cost[i][j];

        System.out.println(tc[3][3]);
    }

    int min(int x, int y, int z) {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }
}
