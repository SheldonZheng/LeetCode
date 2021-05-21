/**
 * LeetCode 1035 Uncrossed Lines
 */
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return 0;
        }
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= nums1.length; i++) {
            int a = nums1[i - 1];
            for (int j = 1; j <= nums2.length; j++) {
                int b = nums2[j - 1];
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
