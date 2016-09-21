/**
 * Created by Baiye on 2016/9/21.
 */

/**
 * LeetCode.231.Power of Two
 * 参见326题解法
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0?!(1073741824 % n != 0):false;
    }
}
