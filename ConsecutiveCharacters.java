/**
 * LeetCode 1445 Consecutive Characters
 */
class Solution {
    public int maxPower(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int l = 0,r = 1;
        int res = 1;
        while (l < chars.length && r < chars.length) {
            char cur = chars[l];
            while (r < chars.length && chars[r] == cur) {
                r++;
            }
            int curCount = r - l;
            res = Math.max(curCount,res);
            l = r ;
        }
        return res;
    }
}
