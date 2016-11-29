/**
 * Created by Baiye on 2016/11/29.
 */

/**
 * LeetCode.172.Factorial Trailing Zeroes 计算阶乘后面有几个0
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if(n < 1)
            return 0;

        int result = 0;
        while(n/5 != 0)
        {
            n /= 5;
            result += n;
        }
        return result;
    }
}
