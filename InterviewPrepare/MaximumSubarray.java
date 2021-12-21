/*
 * LeetCode 53 Maximum Subarray
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cur = 0;
        int maxRes = nums[0];
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(cur + nums[i],nums[i]);
            maxRes = Math.max(maxRes,cur);
        }
        return maxRes;
    }
}
