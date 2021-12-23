/**
 * LeetCode 152 Maximum Product Subarray
 */
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int maxCur = nums[0];
        int minCur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMaxCur = maxCur;
            int tempMinCur = minCur;
            maxCur = Math.max(tempMaxCur * nums[i],Math.max(tempMinCur * nums[i],nums[i]));
            minCur = Math.min(tempMinCur * nums[i],Math.min(tempMaxCur * nums[i],nums[i]));
            res = Math.max(res,maxCur);
        }
        return res;
    }
}
