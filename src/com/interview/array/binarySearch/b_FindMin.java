package com.interview.array.binarySearch;

public class b_FindMin {

    public int findMin() {
        int[] arr = {11, 13, 15, 17, 9};
        int n = arr.length;
        int low = 0;
        int high = n-1;

        if (arr[low] <= arr[high])
            return arr[low];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < arr[mid - 1])        // Check if mid is the minimum element
                return arr[mid];

            if (arr[mid] > arr[high])       // If the right half is sorted, the minimum element must be in the left half
                low = mid + 1;
            else      // If the left half is sorted, the minimum element must be in the right half
                high = mid - 1;
        }
        return -1;
    }

    public int minFromSortedRotated(){
        int[] arr = {11, 3, 5, 7, 9};
        int low = 0;
        int high = arr.length - 1;

        while(low < high) {
            int mid = low + (high - low)/2;
            if (arr[mid] == arr[high])
                high--;
            else if(arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        return arr[high];
    }
}
