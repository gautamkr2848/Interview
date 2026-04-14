package com.interview.matrix;

//All the rows are sorted
//start from top right corner
//Time complexity - O(m + n)

public class RowWithMax1 {

    public void rowWithMax1() {
        int arr[][] = {{0, 0, 1, 1},
                       {0, 0, 0, 1},
                       {0, 0, 0, 0},
                       {0, 1, 1, 1}};

        int row = 0, i, j;
        for (i = 0, j = arr[0].length - 1; i < arr.length; i++) {
            while (j >= 0 && arr[i][j] == 1) {
                row = i;
                j--;
            }
        }
        if(row==0 && arr[0][arr[0].length-1]==0)
            System.out.println(-1);
        System.out.print("Row number = " + (row + 1) + ", MaxCount = " + (arr.length - 1 - j));
    }
}
