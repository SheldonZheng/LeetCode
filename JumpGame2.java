/**
 * LeetCode 55 Jump Game
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max,i + nums[i]);
                if (max >= n - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
