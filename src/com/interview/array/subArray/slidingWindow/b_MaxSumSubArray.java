package com.interview.array.subArray.slidingWindow;

/*Input  : arr[] = {100, 200, 300, 400}
        k = 2
        Output : 700*/

public class b_MaxSumSubArray {

    public static void maxSumSubArray(){
        int[] arr = {1000, 4, 2, 10, 23, 3, 1, 0, 20};
        int size = 3;
        int sum = 0;
        for(int i=0; i<size; i++)
            sum = sum + arr[i];
        int max = Math.max(sum, Integer.MIN_VALUE);

        for(int i=1, j=size; j<arr.length; i++, j++){
            sum = sum + arr[j] - arr[i-1];
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        maxSumSubArray();
    }
}
