/**
 * LeetCode 26 Remove Duplicates from Sorted Array
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int rightPoint = 1;
        int leftPoint = 0;
        int n = nums.length;
        while (rightPoint < n) {
            if (nums[leftPoint] == nums[rightPoint]) {
                rightPoint++;
                continue;
            }
            nums[++leftPoint] = nums[rightPoint];
            rightPoint++;
        }

        return leftPoint + 1;
    }
}
