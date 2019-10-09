/**
 * LeetCode 34 Find First and Last Position of Element in Sorted Array
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return findStartAndEnd(nums,target,mid);
            }
        }
        return result;
    }

    public int[] findStartAndEnd(int[] nums,int target,int pos) {
        int start = -1;
        int end = -1;
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] == target) {
                end = i;
            }
        }

        for (int i = pos; i >= 0; i--) {
            if (nums[i] == target) {
                start = i;
            }
        }
        return new int[]{start,end};
    }
}
