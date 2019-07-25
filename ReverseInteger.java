/**
 * LeetCode 7 Reverse Integer
 */

class Solution {
    public static int reverse(int x) {
        if ((x < 10 && x >= 0) || (x > -10 && x <= 0)) {
            return x;
        }

        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            //0x7fffffff
            if ((rev > Integer.MAX_VALUE / 10) || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            //0x80000000
            if ((rev < Integer.MIN_VALUE / 10) || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;

    }
}
