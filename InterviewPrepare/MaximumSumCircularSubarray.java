/**
 * LeetCode 918 Maximum Sum Circular Subarray
 */
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sumAll = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int curMax = 0 ,curMin = 0;
        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i],nums[i]);
            curMin = Math.min(curMin + nums[i],nums[i]);
            maxSum = Math.max(maxSum,curMax);
            minSum = Math.min(minSum,curMin);
            sumAll += nums[i];
        }
        return maxSum > 0 ? Math.max(maxSum,sumAll - minSum) : maxSum;
    }
}
