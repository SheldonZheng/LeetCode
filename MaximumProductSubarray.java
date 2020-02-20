/**
 * LeetCode 152 Maximum Product Subarray
 */
class Solution {
   public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int tMax = 1;
        int tMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = tMax;
                tMax = tMin;
                tMin = tmp;
            }
            tMax = Math.max(tMax * nums[i],nums[i]);
            tMin = Math.min(tMin * nums[i],nums[i]);

            max = Math.max(max,tMax);

        }
        return max;
    }
}
