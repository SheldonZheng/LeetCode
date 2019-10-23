/**
 * LeetCode 674 Longest Continuous Increasing Subsequence
 */
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                max = Math.max(max,find(nums,i));
            }
        }
        return max;
    }

    private int find(int[] nums,int pos) {
        int length = 1;
        for (int i = pos; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                length++;
            } else {
                return length;
            }
        }
        return length;
    }
}
