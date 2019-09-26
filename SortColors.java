/**
 * LeetCode 75 Sort Colors
 */
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }

        int pointZ = 0;
        int pointT = nums.length - 1;
        int cur = 0;
        while (cur <= pointT) {
            if (nums[cur] == 0) {
                int temp = nums[pointZ];
                nums[pointZ] = nums[cur];
                nums[cur] = temp;
                cur++;
                pointZ++;
            } else if (nums[cur] == 1) {
                cur++;
            } else if (nums[cur] == 2) {
                int temp = nums[pointT];
                nums[pointT] = nums[cur];
                nums[cur] = temp;
                pointT--;
            }
        }
        return ;
    }
}
