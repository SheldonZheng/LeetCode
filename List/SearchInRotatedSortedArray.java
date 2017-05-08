package List;

/**
 * Created by Baiye on 08/05/2017.
 */

/**
 * LeetCode.33.Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        if(nums[start] == target)
            return start;
        if(nums[end] == target)
            return end;
        while (start + 1 < end) {
            mid = start + (end - start) /2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > nums[start]) {
                if (target >= nums[start] && target <= nums[mid])
                    end = mid;
                else {
                    start = mid;
                }
            }
            else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
        }

        return -1;
    }
}
