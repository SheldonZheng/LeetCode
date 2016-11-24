package List;

/**
 * Created by Baiye on 2016/11/24.
 */

/**
 * LeetCode.26.Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;

        int p = 1;
        for(int r = 1;r < nums.length;r++)
        {
            if(nums[r] != nums[r - 1])
                nums[p++] = nums[r];
        }

        return p;
    }
}
