/**
 * LeetCode 392 Is Subsequence
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int a = 0;
        int last = s.length();
        if (last == 0) {
            return true;
        }
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(a) == t.charAt(i)) {
                a++;
            }
            if (a == last) {
                return true;
            }
        }
        return false;
    }
}
