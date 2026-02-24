package com.interview.dynamic.one_dim_dp;

/*For two

    1 => 1
    1, 2 => Either 1 0r 2
    1, 2, 3 => If we leave 3, then sum[i-1]
               If we leave 2, then sum[i-2] + arr[i]


 For three

    1 => 1
    1, 2 => 1 + 2
    1, 2, 3 => If we leave 3, then 1 + 2
                If we leave 2, then 1 + 3
                If we leave 1, then 2 + 3
    1, 2, 3, 4 => If we leave 4, then sum[i-1]
                  If we lave 3, then sum[i-2] + arr[i]
                  If we leave 2, then sum[i-3] + arr[i] + arr[i-1]

 */


public class c_MaxStolenVaue {

    public int maxLoot() {
        int house[] = {6, 7, 1, 3, 8, 2, 4};
        int n = house.length;
        int[] sum = new int[n];

        if(house.length >= 2) {
            sum[0] = house[0];
            sum[1] = Math.max(house[0], house[1]);
        }

        for (int i = 2; i<n; i++)
            sum[i] = Math.max(sum[i-1], house[i] + sum[i-2]);

        return sum[n-1];
    }

    //Max Sum such that no three elements are consecutive
    public void maxSumNoThreeConsecutive(){
        int[] arr = { 100, 1000, 100, 1000, 1 };
        int n = arr.length;
        int[] sum = new int[n];

        if(arr.length >= 3){
            sum[0] = arr[0];
            sum[1] = arr[0] + arr[1];
            sum[2] = max(sum[1], arr[0] + arr[2], arr[1] + arr[2]);
        }

        // We have three cases
        // 1) Exclude arr[i], i.e., sum[i] = sum[i-1]
        // 2) Exclude arr[i-1], i.e., sum[i] = sum[i-2] + arr[i]
        // 3) Exclude arr[i-2], i.e., sum[i] = sum[i-3] + arr[i] + arr[i-1]

        for(int i=3; i<n; i++)
            sum[i] = max(sum[i - 1], sum[i - 2] + arr[i], sum[i - 3] + arr[i] + arr[i - 1]);

        System.out.print(sum[n - 1]);
    }

    private int max(int x, int y, int z) {
        if(x < y)
            return (y < z) ? z : y;
        else
            return (x < z) ? z : x;
    }

    public void maxLoot_circularArray() {
        // use same logic
        // include 1st element and exclude last element
        // include last element and exclude 1st element

        // return max of both the o/p
    }
}
