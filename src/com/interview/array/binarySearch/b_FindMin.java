package com.interview.array.binarySearch;

public class b_FindMin {

    public static int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            if (arr[low] < arr[high])
                return arr[low];

            int mid = (low + high) / 2;

            if (arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }

        return arr[low];
    }

    public static void main(String[] args){
        int[] arr = {18, 11, 13, 15, 17};
        System.out.println(findMin(arr));
    }
}
