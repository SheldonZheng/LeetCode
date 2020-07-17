/**
 * LeetCode 152 Maximum Product Subarray
 */
class Solution {
   public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int tmpMax = 1;
        int tmpMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = tmpMax;
                tmpMax = tmpMin;
                tmpMin = temp;
            }

            tmpMax = Math.max(tmpMax * nums[i],nums[i]);
            tmpMin = Math.min(tmpMin * nums[i],nums[i]);

            max = Math.max(tmpMax,max);
        }
        return max;
    }
}
