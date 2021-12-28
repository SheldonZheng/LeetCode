/**
 * LeetCode 121 Best Time to Buy and Sell Stock
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            res = Math.max(res,prices[i] - minPrice);
        }
        return res;
    }
}
