/**
 * LeetCode 5 Longest Palindromic Substring Solution 2
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(searchPalindrome(s,i,i),searchPalindrome(s,i,i + 1));
            if (len > max - start) {
                start = i - (len - 1) / 2;
                max = i + len / 2;
            }
        }
        return s.substring(start,max + 1);

    }

    public int searchPalindrome(String s,int left ,int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
