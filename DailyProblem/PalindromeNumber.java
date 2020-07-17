/**
 * LeetCode 9 Palindrome Number
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int resNum = 0;
        while (x > resNum) {
            resNum = resNum * 10 + (x % 10);
            x /= 10;
        }

        return x == resNum || x == resNum / 10;
    }
}
