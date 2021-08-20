/**
 * LeetCode 541 Reverse String II
 */
class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length ; i += 2 * k) {
            int l = i;
            int r = i + k - 1;
            if (chars.length - i <= k) {
                r = chars.length - 1;
            }
            while (l < r) {
                char t = chars[l];
                chars[l] = chars[r];
                chars[r] = t;
                l++;
                r--;
            }
        }
        return new String(chars);
    }
}
