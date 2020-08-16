package com.interview.array.sort;

public class MergeSort {

    public void mergeSort(){
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        ms(arr, 0, n-1);

        for(int i=0; i<n; i++)
            System.out.print(arr[i] + " ");
    }

    private void ms(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            ms(arr, l, m);
            ms(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}