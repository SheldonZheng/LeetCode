package DP;

/**
 * Created by Baiye on 2016/10/28.
 */

/**
 * LeetCode.198.House Robber
 *
 * DP初级水题 定义两个变量记录要不要偷当前房子的最大值 然后比较一下 求解
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null)
            return 0;
        int best0 = 0;
        int best1 = 0;
        for(int i = 0;i < nums.length;i++)
        {
            int temp = best0;
            best0 = Math.max(best0,best1);
            best1 = temp + nums[i];
        }
        return Math.max(best0,best1);
    }
}
