/**
 * LeetCode 53 Maximum Subarray
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
