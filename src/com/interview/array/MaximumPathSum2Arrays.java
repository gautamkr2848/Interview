package com.interview.array;

//Given two sorted arrays, the arrays may have some common elements. Find the sum of the maximum
// sum path to reach from the beginning of any array to the end of any of the two arrays. We can
// switch from one array to another array only at common elements.

/*

Input: ar1[] = {2, 3, 7, 10, 12}, ar2[] = {1, 5, 7, 8}
Output: 35
Explanation: 35 is sum of 1 + 5 + 7 + 10 + 12

 */

public class MaximumPathSum2Arrays {

    public static void main(String[] args) {
        MaximumPathSum2Arrays mps = new MaximumPathSum2Arrays();
        mps.maxPathSum();
    }

    public void maxPathSum(){
        int a[] = {2, 3, 7, 10, 12};
        int b[] = {1, 5, 7, 8};

        int m = a.length;
        int n = b.length;

        int i=0, j=0, sum1 = 0, sum2 = 0, res = 0;

        while(i < m && j < n) {
            if(a[i] < b[j])
                sum1 = sum1 + a[i++];
            else if(a[i] > b[j])
                sum2 = sum2 + b[j++];
            else {
                res = res + Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;
                while(a[i] == b[j] && i < m && j < n){
                    res = res + a[i];
                    i++;
                    j++;
                }
            }
        }

        while (i < m)
            res = res + a[i++];

        while (j < n)
            res = res + b[j++];

        System.out.println(res);
    }
}
