package com.interview.array;

/*
        Input:
        Stock Price: {1, 5, 2, 3, 7, 6, 4, 5}
        k = 3

        Output: The maximum profit is 10 (sum of 4, 5 and 1)

        Buy at a price 1 and sell at a price 5
        Buy at a price 2 and sell at a price 7
        Buy at a price 4 and sell at a price 5

        If we are allowed to stock only once, then we can find the maximum difference between two elements in the array,
        where the smaller element appears before the larger element.

        Now we are only allowed to make at most k stock transactions. We can solve the problem by using dynamic
        programming.

*/

public class StockBuySell {

    public void maxProfit() {

        int[] price = {900, 180, 260, 310, 40, 535, 695};
        int profit = 0;

        for (int i = 1; i < price.length; i++) {
            int diff = price[i] - price[i - 1];
            if (diff > 0) {
                System.out.println("Buy on day : " + (i - 1) + "  Sell on day : " + i);
                profit = profit + diff;
            }
        }
        System.out.println("Maximum profit : " + profit);
    }

    //        Let profit[i][j] represent maximum profit using at most i transactions up to day j (including day j). Then the
    //        relation is:
    //            i = no. of transactions
    //            j = days
    //            profit[i][j] = max(profit[i][j-1], max(price[j] – price[m] + profit[i-1][m])) for all m in range [0, j-1]
    //
    //        profit[i][j] will be maximum of –
    //            1. profit[i][j-1] which represents not doing any transaction on the jth day.
    //            2. price[j] - price[m] + profit[i-1][m]
    //                Selling on jth day, i.e buying on some day before j i.e mth day + profit upto mth day

    public int maxProfit(int[] price, int n, int k) {
        int[][] profit = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                int max_profit_so_far = 0;

                for (int m = 0; m < j; m++)
                    max_profit_so_far = Math.max(max_profit_so_far, price[j] - price[m] + profit[i - 1][m]);

                profit[i][j] = Math.max(profit[i][j - 1], max_profit_so_far);
            }
        }

        return profit[k][n - 1];
    }

    //Space Complexity: O(n*k)
    //Time Complexity: O(k.n2)

    /*
    Optimized Solution

    profit[i][j] = max(profit[i][j-1], max(price[j] – price[m] + profit[i-1][m])) for all m in range [0, j-1]

    If we carefully notice,
        max(price[j] – price[m] + profit[i-1][m]) for all m in range [0, j-1]
        can be rewritten as,
        = price[j] + max(profit[i-1][m] – price[m]) for all m in range [0, i-1]
        = price[j] + max(prevDiff, profit[i-1][j-1] – price[j-1]) where prevDiff is max(profit[i-1][m] – price[m]) for all j in range [0, i-2]

    So, if we have already calculated max(profit[t-1][j] – price[j]) for all j in range [0, i-2], we can calculate it for j = i – 1 in constant time. In other words, we don’t have to look back in the range [0, i-1] anymore to find out best day to buy. We can determine that in constant time using below revised relation.
profit[i][j] = max(profit[i][j-1], price[j] + max(prevDiff, profit [i-1][j-1] – price[j-1])
where prevDiff is max(profit[i-1][j] – price[j]) for all j in range [0, i-2]

    {10, 22, 5, 75, 65, 80}

    Matrix :
        0   0   0   0   0   0   0
        0   12  12  70  70  75  0
        0   12  12  82  82  87  0


   {12, 14, 17, 10, 14, 13, 12, 15}

   Matrix :
        0   0   0   0   0   0   0   0   0
        0   2   5   5   5   5   5   5   0
        0   2   5   5   9   9   9   10  0
        0   2   5   5   9   9   9   12  0

*/

    public int maxProfit_2() {

        int[] price = {12, 14, 17, 10, 14, 13, 12, 15};
        int k = 3;

        int n = price.length;
        int t[][] = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                prevDiff = Math.max(prevDiff, t[i - 1][j - 1] - price[j - 1]);
                t[i][j] = Math.max(t[i][j - 1], price[j] + prevDiff);
            }
        }
        return t[k][n - 1];
    }

    // Time complexity - O(k * n)

    // For 1 txn
    public void maxProfitWithOneTxn(int arr[]) {
        int minSoFar = arr[0];
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minSoFar)
                minSoFar = arr[i];
            else if(arr[i] - minSoFar > profit)
                profit = arr[i] - minSoFar;
        }

        System.out.print(profit);
    }

    //For 2 txns

    // first_buy: Max profit after first buy (negative, since buying costs money).
    // first_sell: Max profit after first sell.
    // second_buy: Max profit after second buy (after selling first).
    // second_sell: Max profit after second sell.
    public static int maxtwobuysell(int arr[]) {
        int n = arr.length;
        int first_buy = Integer.MIN_VALUE;
        int first_sell = 0;
        int second_buy = Integer.MIN_VALUE;
        int second_sell = 0;

        for(int i = 0; i < n; i++) {

            first_buy = Math.max(first_buy, 0 - arr[i]);
            first_sell = Math.max(first_sell, first_buy + arr[i]);
            second_buy = Math.max(second_buy, first_sell - arr[i]);
            second_sell = Math.max(second_sell, second_buy + arr[i]);

        }
        return second_sell;
    }

    public static void main(String[] args) {
        int price[] = {3, 1, 6, 1, 2, 4};
        System.out.println(maxProfit(price));
    }

    // With cooldown period

    // find the maximum profit that you can make by buying and selling stock with the restriction of  After you sell your
    // stock, you cannot buy stock on the next day (i.e., cooldown one day).
    public static int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy = Integer.MIN_VALUE;
        for (int i=0; i<prices.length; i++) {
            prev_buy = buy;
            buy = Math.max(prev_sell - prices[i], prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + prices[i], prev_sell);
        }
        return sell;
    }

    // 3 possible states : buy, sell, rest

    // buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
    // sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);

    // b0 = Math.max(b1, s2 - prices[i]);
    // s0 = Math.max(s1, b1 + prices[i]);
    public static int maxProfitWithCooldown(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;

        for(int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }

    // We can’t buy a stock on the very next day of selling it. This is the cooldown clause.
    public static int stockProfit(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n + 2][2];

        // Iterate through the array backwards
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[i + 1][0], -arr[i] + dp[i + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[i + 1][1], arr[i] + dp[i + 2][0]);
                }

                dp[i][buy] = profit;
            }
        }

        // The maximum profit is stored in dp[0][0]
        return dp[0][0];
    }

    //Time Complexity: O(N*2)
    //Space Complexity: O(N*2)

    // After every transaction, there is a transaction fee (‘fee’) associated with it.
    public static int maximumProfit(int n, int fee, int[] arr) {
        // Handle the base case when n is 0
        if (n == 0)
            return 0;

        int dp[][] = new int[n + 1][2];

        // Iterate through the array backwards
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[i + 1][0], -arr[i] + dp[i + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[i + 1][1], arr[i] - fee + dp[i + 1][0]);
                }

                dp[i][buy] = profit;
            }
        }
        return dp[0][0];
    }

    // Time Complexity: O(N*2)
    // Space Complexity: O(N*2)

    public static int getMaximumProfit(int[] arr, int n) {
        int[][] dp = new int[n + 1][2];

        dp[n][0] = dp[n][1] = 0;        // Base condition: If we have no stocks to buy or sell, profit is 0
        int profit = 0;

        // Iterate through the array in reverse to calculate the maximum profit
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0)  // We can buy the stock
                    profit = Math.max(0 + dp[i + 1][0], -arr[i] + dp[i + 1][1]);

                if (buy == 1)  // We can sell the stock
                    profit = Math.max(0 + dp[i + 1][1], arr[i] + dp[i + 1][0]);

                dp[i][buy] = profit;
            }
        }
        return dp[0][0];
    }

    // Time Complexity: O(N*2)
    // Space Complexity: O(N*2)
}