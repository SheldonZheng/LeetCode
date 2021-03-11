/**
 * LeetCode 268 Missing Number
 */
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int allSum = nums.length * (nums.length + 1) / 2;
        for (int num : nums) {
            allSum -= num;
        }
        return allSum;
    }
}
