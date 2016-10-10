/**
 * Created by Baiye on 2016/10/10.
 */

/**
 * LeetCode.121.Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 *  依旧是动态规划初级题目 定义一个指针指向遍历到此处之前的最小买入值
 *  存储遍历到此处之前的最大收益
 *  即使最小买入值更新 那么最大收益依旧是最大收益
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;

        int curMin = prices[0];
        int maxProfit = 0;

        for(int i = 1;i < prices.length;i++)
        {
            maxProfit = maxProfit > prices[i] - curMin?maxProfit:prices[i] - curMin;
            curMin = curMin > prices[i]?prices[i]:curMin;
        }

        return maxProfit;
    }
}
