/**
 * Created by Baiye on 2016/9/19.
 */

/**
 * LeetCode.326.Power of Three
 * Given an integer, write a function to determine if it is a power of three.
 * 题目建议不要使用递归和循环；
 *
 * 解法：取巧用了一个办法，任何一个3的x次方一定能被int型里最大的3的x次方整除，这样判断一下就好了，非常骚
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return n > 0?!(1162261467 % n != 0):false;
    }
}
