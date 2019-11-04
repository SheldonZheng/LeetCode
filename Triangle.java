/**
 * LeetCode 120 Triangle
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size() + 1];
        for (int level = triangle.size() - 1; level >= 0; level--) {
            for (int i = 0; i < triangle.get(level).size(); i++) {
                dp[i] = Math.min(dp[i],dp[i + 1]) + triangle.get(level).get(i);
            }
        }
        return dp[0];
    }
}
