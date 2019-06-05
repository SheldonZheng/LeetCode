//LeetCode 713
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return 0;
        }
        int caclR = 1; // init 1 not 0
        int r = 0;
        int i = 0; // slow
        for (int j = 0 /* fast */; j < nums.length; j++) {
            caclR *= nums[j];
            while (i <= j && caclR >= k) {
                caclR /= nums[i];
                i++;
            }
            r = (r + j + 1 - i);
        }
        return r;
    }
}
