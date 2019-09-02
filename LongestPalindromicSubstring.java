/**
 * LeetCode 5 Longest Palindromic Substring
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int max = 1;
        int len = s.length();
        int [][]dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i+1] = 1;
                start = i;
                max = 2;
            }
        }
        for (int l = 3 ; l <= len;l++) {
            for (int i = 0; i + l - 1 < len; i++) {
                int j = l + i - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    start = i;
                    max = l;
                }
            }
        }

        return s.substring(start,start + max);
    }
}
