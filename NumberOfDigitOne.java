/**
 * LeetCode 233 Number of Digit One
 */
class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        long mulk = 1;
        int res = 0;
        for (int k = 0; mulk <= n;k++) {
            res += (n / (mulk * 10)) *  mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1,0),mulk);
            mulk *= 10;
        }
        return res;
    }
}
