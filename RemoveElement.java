/**
 * Created by Baiye on 2016/11/7.
 */

/**
 * LeetCode.27 Remove Element
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val)
                nums[length++] = nums[i];
        }

        return length;
    }
}
