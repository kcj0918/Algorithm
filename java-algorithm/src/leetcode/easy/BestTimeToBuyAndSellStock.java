package leetcode.easy;

public class BestTimeToBuyAndSellStock {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     */
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int[] prices) {
        int profit = 0;
        int curr = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (curr > prices[i]) {
                curr = prices[i];
            }
            profit = Math.max(profit, prices[i] - curr);
        }
        return profit;
    }
}
