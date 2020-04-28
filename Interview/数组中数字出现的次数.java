/**
 * LeetCode Interview 56 数组中数字出现的次数
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        xor &= -xor;
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((xor & num) == 0) {
                a ^= num;
            }
            else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
}
