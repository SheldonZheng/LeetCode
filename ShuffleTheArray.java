/**
    LeetCode 1470 Shuffle the Array
 */
 class Solution {
    public int[] shuffle(int[] nums, int n) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] result = new int[n * 2];
        for (int i = 0; i < n; i++) {
            result[i * 2] = nums[i];
            result[i * 2 + 1] = nums[n + i];
        }
        return result;
    }
 }