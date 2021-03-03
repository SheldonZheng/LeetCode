/**
 * LeetCode 42 Trapping Rain Water
 */
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int lMax = height[0];
        int rMax = height[height.length - 1];
        int res = 0;

        while (left <= right) {
            lMax = Math.max(lMax,height[left]);
            rMax = Math.max(rMax,height[right]);

            if (lMax < rMax) {
                res += lMax - height[left];
                left++;
            } else {
                res += rMax - height[right];
                right--;
            }
        }
        return res;
    }
}
