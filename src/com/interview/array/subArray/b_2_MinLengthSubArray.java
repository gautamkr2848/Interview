package com.interview.array.subArray;

// 2 3 1 2 4 3
// target = 7

// Not applicable for array having negative elements

public class b_2_MinLengthSubArray {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(subArrayCount(a, a.length, target));
    }

    public static int subArrayCount(int A[], int N, int K) {

        int i = 0, j = 0, sum = 0, count = 0;
        int minLength = Integer.MAX_VALUE;

        while (j < N) {

            sum += A[j];

            if (sum == K) {
                minLength = Math.min(minLength, j+1);
            } else {
                while (sum > K) {
                    sum -= A[i];
                    i++;
                }
                if(sum == K){
                    minLength = Math.min(minLength, j-i+1);
                }
            }
            j++;
        }
        return minLength;
    }
}
