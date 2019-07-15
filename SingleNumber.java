/**
 * LeetCode 136 Single Number
 */
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (i == 1 && nums[i] != nums[0]) {
                return nums[0];
            }
            if ((nums.length - 1 == i && nums[i] != nums[i-1]) || (nums[i - 1] != nums[i] && nums[i] != nums[i + 1])) {
                return nums[i];
            }
        }

        return -1;
    }
}
