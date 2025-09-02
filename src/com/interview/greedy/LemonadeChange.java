package com.interview.greedy;

// At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a
// time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
// You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
//
// Note that you do not have any change in hand at first.
//
// Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every
// customer with the correct change, or false otherwise.

public class LemonadeChange {

    public static boolean test(){

        int[] bills = {5, 5, 5, 20, 5, 10, 10, 5};
        int N = 5;
        int five = 0,  ten = 0;

        for(int i=0; i<N; i++) {
            if(bills[i] == 5) {
                five++;
            } else if(bills[i] == 10) {
                if(five == 0)
                    return false;

                ten++;
                five--;
            } else {
                if((ten >= 1 && five >= 1)) {
                    ten--;
                    five--;
                } else if((ten ==0 && five >= 3)){
                    five = five - 3;
                }else
                    return false;
            }
        }
        return true;
    }
}
