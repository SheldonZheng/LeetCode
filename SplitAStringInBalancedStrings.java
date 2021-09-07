/**
 * LeetCode 1221 Split a String in Balanced Strings 
 */
class Solution {
    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int res = 0;
        int rc = 0;
        int lc = 0;
        for (char c : chars) {
            if (c == 'R') {
                rc++;
            } else {
                lc++;
            }
            if (rc == lc && rc != 0 && lc != 0) {
                res++;
                rc = 0;
                lc = 0;
            } 
        }
        return res;
    }
}
