/**
 * LeetCode 1218 Longest Arithmetic Subsequence of Given Difference
 */
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        Map<Integer,Integer> dp = new HashMap<>();
        for (int i : arr) {
            dp.put(i,dp.getOrDefault(i - difference,0) + 1);
            res = Math.max(res,dp.get(i));
        }
        return res;
    }
}
