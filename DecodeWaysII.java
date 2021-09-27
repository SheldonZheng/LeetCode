/**
 * LeetCode 639 Decode Ways II
 */
class Solution {
    static final int MOD = 1000000007;

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        long a = 0,b = 1,c = 0;
        for (int i = 1; i <= s.length(); i++) {
            c = b * check1digit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * check2digit(s.charAt(i - 2),s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    public int check1digit(char c) {
        if (c == '0') {
            return 0;
        }
        return c == '*' ? 9 : 1;
    }

    public int check2digit(char c1,char c2) {
        if (c1 == '*' && c2 == '*') {
            return 15;
        }
        if (c1 == '*') {
            return c2 <= '6' ? 2 : 1;
        }
        if (c2 == '*') {
            if (c1 == '1') {
                return 9;
            }
            if (c1 == '2') {
                return 6;
            }
            return 0;
        }
        return (c1 != '0' && (c1 - '0') * 10 + (c2 - '0') <= 26) ? 1 : 0;
    }
}
