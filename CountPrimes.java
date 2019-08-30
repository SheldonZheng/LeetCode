/**
 * LeetCode 204 Count Primes
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

    private boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 5; i <= sqrt; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
     }
}
