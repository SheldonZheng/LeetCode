/**
 * LeetCode 162 Find Peak Element
 */
class Solution {
     public int findPeakElement(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        int l = 0,r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
