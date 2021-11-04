/**
 * LeetCode 367 Valid Perfect Square
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        int left = 0;
        int right = num / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            long re = (long) mid * mid;
            if (re < num) {
                left = mid + 1;
            } else if (re > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
