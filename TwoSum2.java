/**
 * LeetCode 1 Two Sum
 */
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            int f = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (f == nums[j]) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
