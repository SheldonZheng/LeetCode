/**
 * Created by Baiye on 2016/8/9.
 */

/**
 * LeetCode 371
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.
 * 采用进位补位的方式算出两个数的和
 */
public class SumTwoIntegerWhitoutPlusAndMinus {
    public int getSum(int a,int b)
    {
        while(b != 0)
        {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
