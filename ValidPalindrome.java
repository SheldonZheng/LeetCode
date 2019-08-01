/**
 * LeetCode 125 Valid Palindrome
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] strs = s.toCharArray();
        int l = 0;
        int r = strs.length - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(strs[l])) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(strs[r])) {
                r--;
                continue;
            }
            if (Character.toLowerCase(strs[l]) != Character.toLowerCase(strs[r])) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}
