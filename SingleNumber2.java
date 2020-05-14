/**
 * LeetCode 136 Single Number
 */
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
