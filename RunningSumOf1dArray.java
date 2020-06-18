/**
 * LeetCode 1480 Running Sum of 1d Array
 */
class Solution {
    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int pre = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            res[i] = pre;
        }
        return res;
    }
}
