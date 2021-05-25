/**
 * LeetCode 139 Word Break
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<String> container = new HashSet<>(wordDict);
        int maxLength = 0;
        for (String str : wordDict) {
            maxLength = Math.max(maxLength,str.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (i - j > maxLength) {
                    break;
                }
                if (dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
