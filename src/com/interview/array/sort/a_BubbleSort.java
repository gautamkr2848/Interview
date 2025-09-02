package com.interview.array.sort;

/*First Pass:
        ( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ),  swaps since 5 > 1.
        ( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
        ( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
        ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5),
Second Pass:
        ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
        ( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
        ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
        ( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )*/

public class a_BubbleSort {

    e_QuickSort q = new e_QuickSort();
    public void bubbleSort(){
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    q.swap(arr, j, j+1);
            }
        }

        for(int i=0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void bubbleSort2(){
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if (arr[j] > arr[j + 1])
                    q.swap(arr, j, j+1);
            }
        }
        System.out.println();
        for(int i=0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        a_BubbleSort b = new a_BubbleSort();
        b.bubbleSort();
        b.bubbleSort2();
    }
}
