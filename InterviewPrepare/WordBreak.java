/**
 * LeetCode 139 Word Break
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<String> container = new HashSet<>();
        int minLength = 0;
        for (String s1 : wordDict) {
            container.add(s1);
            minLength = Math.min(minLength,s1.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i - minLength; j++) {
                if (dp[j] && container.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
