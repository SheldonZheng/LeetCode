/**
 * LeetCode 334 Increasing Triplet Subsequence
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int s = Integer.MAX_VALUE;
        int l = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < s) {
                s = nums[i];
            } else if (nums[i] > s && nums[i] < l) {
                l = nums[i];
            } else if (nums[i] > l) {
                return true;
            }
        }
        return false;
    }
}
