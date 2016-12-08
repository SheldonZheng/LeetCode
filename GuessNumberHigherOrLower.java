/**
 * Created by Baiye on 2016/12/8.
 */

/**
 * LeetCode.374.Guess Number Higher or Lower
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int mid = 0;
        int left = 1;
        int right = n;
        while(left <= right)
        {
            mid = left + (right - left) / 2;
            int result = guess(mid);
            if(result == 0)
                return mid;
            else if (result == 1)
                left = mid + 1;
            else
                 right = mid - 1;
        }
        return left;
    }

    private int guess(int num)
    {
        return 0;
    }
}
