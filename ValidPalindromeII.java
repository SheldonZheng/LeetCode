/**
 * LeetCode 680 Valid Palindrome II
 */
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }
        return palindrome(s,0,s.length() - 1,1);
    }

    public boolean palindrome(String s,int left,int right,int chance) {
        if (left > right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return palindrome(s,left + 1,right - 1,chance);
        } else {
            if (chance == 0) {
                return false;
            }
            return palindrome(s,left + 1,right,chance - 1) || palindrome(s,left,right - 1,chance - 1);
        }
    }
}
