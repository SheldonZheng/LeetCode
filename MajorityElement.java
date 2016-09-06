/**
 * Created by Baiye on 2016/9/6.
 */

/**
 * LeetCode.169.Majority Element
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 *You may assume that the array is non-empty and the majority element always exist in the array.
 *
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {

        int main = nums[0];
        int count = 1;

        for(int i = 1;i < nums.length;i++)
        {
            if(main == nums[i])
                count++;
            else
            {
                if(count > 0)
                    count--;
                else
                    main = nums[i];
            }
        }
        return main;
    }
}
