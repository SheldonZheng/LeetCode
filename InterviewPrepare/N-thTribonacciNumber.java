/**
 * LeetCode 1137 N-th Tribonacci Number
 */
class Solution {
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int first = 0;
        int second = 1;
        int third = 1;
        int res = 0;
        while (n > 2) {
            res = first + second + third;
            first = second;
            second = third;
            third = res;
            n--;
        }
        return res;
    }
}
