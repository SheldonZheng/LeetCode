/**
 * LeetCode 509 Fibonacci Number 
 */
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int f = 0;
        int s = 1;
        int res = 0;
        while (n > 1) {
            res = f + s;
            f = s;
            s = res;
            n--;
        }
        return res;        
    }
}
