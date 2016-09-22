/**
 * Created by Baiye on 2016/9/22.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode.202.Happy Number
 *
 *
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if(n <= 0)
            return false;
        long num = n;
        Set<Long> tempResult = new HashSet<>();

        while(num <= Integer.MAX_VALUE)
        {
            if(tempResult.contains(num))
                return false;
            else
                tempResult.add(num);

            num = digitSquare(num);
            if(num == 1)
                return true;
        }
        return false;
    }

    private long digitSquare(long num)
    {
        long sum = 0;
        while(num != 0)
        {
            sum += Math.pow(num % 10,2);
            num /= 10;
        }
        return sum;
    }
}
