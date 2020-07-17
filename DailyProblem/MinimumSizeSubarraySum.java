/**
 * LeetCode 209 Minimum Size Subarray Sum
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int left = 0,right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                res = Math.min((right - left + 1) , res);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
