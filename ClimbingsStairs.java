/**
 * Created by Baiye on 2016/10/8.
 */

/**
 * LeetCode.70.Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 简单的题目，明显可以看出f(n) = f(n-1) + f(n -2);
 * 不能使用递归，会溢出；使用动态规划；
 */
public class ClimbingsStairs {
    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2)
            return n;
        int []count = new int[n + 1];
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;

        for(int i = 3;i <= n;++i)
            count[i] = count[i - 1] + count[i - 2];

        return count[n];

    }
}
