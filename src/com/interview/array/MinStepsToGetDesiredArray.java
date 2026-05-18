package com.interview.array;
/*

Consider an array with n elements and value of all the elements is zero. We can perform
following operations on the array.

        Incremental operations : Choose 1 element from the array and increment its value by 1.
        Doubling operation: Double the values of all the elements of array.

        We are given desired array target[] containing n elements. Compute and return the smallest
        possible number of the operations needed to change the array from all zeros to desired array.

N = 3
arr[] = {16, 16, 16}
Output: 7
Explanation: First apply an incremental
operation to each element. Then apply the
doubling operation four times.
Total number of operations is 3+4 = 7.
*/

public class MinStepsToGetDesiredArray {

    public void minStepsToGetDesiredArray(){
        int[] arr = {16, 16, 16};
        int n = 3;
        int result = 0;

        while (true) {      // Keep looping while all elements of arr don't become 0.
            int zero_count = 0;
            int i;  // To find first odd element

            for (i=0; i<n; i++) {
                if (arr[i] % 2 == 1)    // If odd number found
                    break;
                else if (arr[i] == 0)
                    zero_count++;
            }

            // All numbers are 0
            if (zero_count == n)
                System.out.print(result);

            // All numbers are even
            if (i == n) {
                for (int j=0; j<n; j++)
                    arr[j] = arr[j]/2;      // Divide the whole array by 2 and increment result
                result++;
            }

            for (int j=i; j<n; j++) {       // Make all odd numbers even by subtracting one and increment result.
                if (arr[j] % 2 == 1) {
                    arr[j]--;
                    result++;
                }
            }
        }
    }

    // O(n log m) solution
}
