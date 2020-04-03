/**
 * LeetCode 453 Minimum Moves to Equal Array Elements
 */
class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min,num);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] - min;
        }
        return count;
    }
}
