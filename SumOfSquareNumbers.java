/**
 * LeetCode 633 Sum of Square Numbers
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long cur = (left * left) + (right * right);
            if (cur > c) {
                right--;
            } else if (cur < c) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
}
