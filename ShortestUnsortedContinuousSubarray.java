/**
 * LeetCode 581 Shortest Unsorted Continuous Subarray
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int minValue = Integer.MAX_VALUE;
        int left = 0;
        int maxValue = Integer.MIN_VALUE;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxValue > nums[i]) {
                right = i;
            } else {
                maxValue = nums[i];
            }
            if (minValue < nums[nums.length - i - 1]) {
                left = nums.length - i - 1;
            } else {
                minValue = nums[nums.length - i - 1];
            }
        }

        return right == 0 ? 0 : right - left + 1;
    }
}
