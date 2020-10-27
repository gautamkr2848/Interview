package com.interview.array.search;

public class SearchInRotatedArray {

    int search(int arr[], int l, int h, int key) {
        if (l > h) return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == key) return mid;

        if (arr[l] <= arr[mid]) {   /* If arr[l...mid] first subarray is sorted */

            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);

            return search(arr, mid + 1, h, key);
        } else {
            if (key >= arr[mid] && key <= arr[h])
                return search(arr, mid + 1, h, key);

            return search(arr, l, mid - 1, key);
        }
    }

}
