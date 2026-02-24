package com.interview.array;

import java.util.*;

// Lauren has a chart of distinct projected prices for a house over the next several years. She must buy the house in
// one year and sell it in another, and she must do so at a loss. She wants to minimize her financial loss.
//
//Example price ; [20, 15, 8, 2, 12]

// Min Loss = buy at 2nd year and sell at 5th year
// 15 - 12 = 3
//
//Her minimum loss is incurred by purchasing in year  at  and reselling in year  at . Return .

// Loss means substracting 2 values
// Substraction will be min when the values are closer to each other
// In this case, first value should be greater than second value

// https://www.youtube.com/watch?v=X6DqnrpjEWA

public class HouseMinLoss {

    public static void minLoss() {
        List<Integer> prices = Arrays.asList(20, 15, 8, 2, 12);
        int min = Integer.MAX_VALUE;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<prices.size(); i++)
            map.put(prices.get(i), i);

        Collections.sort(prices);
        for(int i = prices.size()-1; i>0; i--){
            if(map.get(prices.get(i)) > map.get(prices.get(i - 1))) {     // Bigger value should have lower index
                continue;
            }
            min = Math.min(min, prices.get(i) - prices.get(i-1));
        }

        System.out.println(min);
    }

    public static void main(String[] args) {
        minLoss();
    }
}
