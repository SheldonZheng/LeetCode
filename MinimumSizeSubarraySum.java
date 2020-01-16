/**
 * LeetCode 209 Minimum Size Subarray Sum
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {

        int left = 0;
        int res = nums.length + 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res,i + 1 - left);
                sum -= nums[left++];
            }
        }
        return res != nums.length + 2 ? res : 0;
    }
}
