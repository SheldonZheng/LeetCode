/**
 * LeetCode 238 Product of Array Except Self
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] output = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= k;
            k *= nums[i];
        }
        return output;
    }
}
