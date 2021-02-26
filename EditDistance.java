/**
 * LeetCode 72 Edit Distance
 */
class Solution {
    public int[][] memo;

    public int minDistance(String word1, String word2) {
        int maxLen = Math.max(word1.length(),word2.length());
        memo = new int[maxLen][maxLen];
        return dp(word1,word2,word1.length() - 1,word2.length() - 1);
    }

    public int dp(String word1,String word2,int i , int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dp(word1, word2, i - 1, j - 1);
            return memo[i][j];
        } else {
            memo[i][j] = Math.min(Math.min(dp(word1,word2,i, j - 1) + 1,dp(word1,word2,i - 1,j) + 1),dp(word1, word2, i - 1, j - 1) + 1);
            return memo[i][j];
        }
    }
}
