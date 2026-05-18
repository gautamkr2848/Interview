package com.interview.graph.DFS;

public class e2_CountIsland {

    static int ROW = 4, COL = 2;
    public static void countIslands() {
        int M[][] = {{0, 1},
                {1, 0},
                {0, 0},
                {1, 0}};
        System.out.println("Number of islands is: " + countIslands(M));
    }

    private static int countIslands(int M[][]) {

        int count = 0;

        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                if (M[i][j] == 1) {
                    DFS(M, i, j);
                    count++;
                }
        return count;
    }

    private static void DFS(int M[][], int row, int col) {
        if(row < 0 || row >= ROW || col < 0 || col >= COL || M[row][col] == 0) {
            return;
        }

        M[row][col] = 0;

        DFS(M, row - 1, col); // Up
        DFS(M, row + 1, col); // Down
        DFS(M, row, col - 1); // Left
        DFS(M, row, col + 1); // Right
//        DFS(M, row - 1, col - 1); // Up-Left
//        DFS(M, row - 1, col + 1); // Up-Right
//        DFS(M, row + 1, col - 1); // Down-Left
//        DFS(M, row + 1, col + 1); // Down-Right
    }

    public static void main(String[] args) {
        countIslands();
    }
}
