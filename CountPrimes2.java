/**
 * LeetCode 204 Count Primes
 */

 */
class Solution {
    public int countPrimes(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
}
