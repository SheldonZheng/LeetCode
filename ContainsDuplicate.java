/**
 * Created by Baiye on 2016/9/9.
 */

import java.util.Arrays;

/**
 * LeetCode.217.Contains Duplicate
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * 判断数组里有没有两个相同的数 先排序，判断相邻的数是否相等就可以了；
 * 注意 数组下标越界问题
 */

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 1;i++)
        {
            if(nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }
}
