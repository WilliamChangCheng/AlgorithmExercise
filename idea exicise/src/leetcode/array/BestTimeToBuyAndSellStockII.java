package leetcode.array;

public class BestTimeToBuyAndSellStockII {
    //多次交易情况
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    //一次交易情况
    /**
     * The points of interest are the peaks and valleys in the given graph.
     * We need to find the largest peak following the smallest valley.
     * We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and maximum profit
     * (maximum difference between selling price and minprice) obtained so far respectively.
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int mainPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (mainPrice > prices[i]) {
                mainPrice = prices[i];
            } else if (prices[i] - mainPrice > maxProfit) {
                maxProfit = prices[i] - mainPrice;
            }
        }
        return maxProfit;
    }
}
