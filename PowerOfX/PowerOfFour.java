package PowerOfX;

/**
 * Created by Baiye on 2016/10/25.
 */

/**
 * LeetCode.342.Power of Four
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * 题目建议不要使用递归和循环；
 *
 * 解法：取巧用了一个办法，任何一个4的x次方一定能被int型里最大的4的x次方整除，这样判断一下就好了，非常骚
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {

        if(num < 0)
            return false;
        if((num & (num - 1)) == 0?false:true)
            return false;
        return num % 3 == 1;

    }
}
