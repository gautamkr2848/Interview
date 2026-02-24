package com.interview.matrix;

/*
1 2 3       3 2 1       3 6 9
4 5 6   =>  6 5 4   =>  2 5 8
7 8 9       9 8 7       1 4 7
*/

public class MatrixRotationClock_90 {

    public static void matrixRotation_2(int matrix[][]){
        //reverse elements of all the rows
        //find the transpose of the matrix

        int n = matrix.length;

        for(int i=0; i<n; i++)
            arrayReverse(matrix[i]);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // print matrix
        for(int i=0; i<n; i++) {
            for (int j = 0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void arrayReverse(int[] a){
        int start = 0;
        int end = a.length-1;
        while(start < end){
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        matrixRotation_2(matrix);

    }
}
