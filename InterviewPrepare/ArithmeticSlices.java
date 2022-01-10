/**
 * LeetCode 413 Arithmetic Slices
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int diff = nums[0] - nums[1];
        int res = 0;
        int curCount = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] - nums[i] == diff) {
                curCount++;
            } else {
                diff = nums[i - 1] - nums[i];
                curCount = 0;
            }
            res += curCount;
        }
        return res;
    }
}
