/**
 * LeetCode 509 Fibonacci Number
 */
class Solution {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }
}
