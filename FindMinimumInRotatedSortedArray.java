/**
 * LeetCode 153 Find Minimum in Rotated Sorted Array
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int lo = 0,hi = nums.length - 1;
        if (nums[lo] < nums[hi]) {
            return nums[lo];
        }
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }
        return nums[lo];
    }

}
