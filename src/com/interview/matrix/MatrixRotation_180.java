package com.interview.matrix;

public class MatrixRotation_180 {

    public static void main(String[] args){
        int mat[][] =   { { 10, 20, 30},
                        { 15, 25, 35 },
                        { 27, 29, 37}};

        for(int i=mat.length - 1; i>=0; i--) {
            for (int j = mat.length - 1; j >= 0; j--) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
