/**
 * LeetCode 409 Longest Palindrome
 */
class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int res = 0;
        for (int i : count) {
            res += i / 2 * 2;
            if (i % 2 == 1 && res % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
