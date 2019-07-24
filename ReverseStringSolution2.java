/**
 * LeetCode 344 Reverse String
 * /
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return ;
        }

        int n = s.length;

        for (int i = 0; i < n / 2; i++) {
            char t = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = t;
        }
        return;
    }
}
