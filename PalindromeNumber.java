/**
 * Created by Baiye on 2016/12/1.
 */

/**
 * LeetCode.9.Palindrome Number
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int temp = x;
        int p = 0;

        while(temp > 0)
        {
            p = (p * 10) + (temp % 10);
            temp /= 10;
        }

        return p == x;
    }
}
