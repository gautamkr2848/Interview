package com.interview.graph.DFS;

public class NumberOfIslands {

    void DFS(int[][] M, int i, int j, int ROW, int COL) {

        // if i less than 0 or j less than 0 or i greater than ROW-1 or j greater than COL-  or if M[i][j] != 1 then we will simply return
        if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != 1)
            return;

        if (M[i][j] == 1) {
            M[i][j] = 0;
            DFS(M, i + 1, j, ROW, COL);     //right side traversal
            DFS(M, i - 1, j, ROW, COL);     //left side traversal
            DFS(M, i, j + 1, ROW, COL);     //upward side traversal
            DFS(M, i, j - 1, ROW, COL);     //downward side traversal
            DFS(M, i + 1, j + 1, ROW, COL); //upward-right side traversal
            DFS(M, i - 1, j - 1, ROW, COL); //downward-left side traversal
            DFS(M, i + 1, j - 1, ROW, COL); //downward-right side traversal
            DFS(M, i - 1, j + 1, ROW, COL); //upward-left side traversal
        }
    }

    public int countIslands(int[][] M) {
        int ROW = M.length;
        int COL = M[0].length;
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == 1) {
                    M[i][j] = 0;
                    count++;
                    DFS(M, i + 1, j, ROW, COL);     //right side traversal
                    DFS(M, i - 1, j, ROW, COL);     //left side traversal
                    DFS(M, i, j + 1, ROW, COL);     //upward side traversal
                    DFS(M, i, j - 1, ROW, COL);     //downward side traversal
                    DFS(M, i + 1, j + 1, ROW, COL); //upward-right side traversal
                    DFS(M, i - 1, j - 1, ROW, COL); //downward-left side traversal
                    DFS(M, i + 1, j - 1, ROW, COL); //downward-right side traversal
                    DFS(M, i - 1, j + 1, ROW, COL); //upward-left side traversal
                }
            }
        }
        return count;
    }
}