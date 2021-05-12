/**
 * LeetCode 1848 Minimum Distance to the Target Element
 */
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        if (nums == null | nums.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                min = Math.min(Math.abs(i - start),min);
            }
        }
        return min;
    }
}
