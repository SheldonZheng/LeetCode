/**
 * LeetCode 1800 Maximum Ascending Subarray Sum
 */
class Solution {
    public int maxAscendingSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0],cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur += nums[i];
            } else {
                cur = nums[i];
            }
            max = Math.max(max,cur);
        }
        return max;
    }
}
