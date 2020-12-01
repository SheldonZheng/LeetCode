/**
 * LeetCode 1672 Richest Customer Wealth
 * /
class Solution {
    public int maximumWealth(int[][] accounts) {
        if (accounts == null || accounts.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 1; j < accounts[i].length; j++) {
                accounts[i][0] += accounts[i][j];
            }
            max = Math.max(accounts[i][0],max);
        }
        return max;
    }
}
