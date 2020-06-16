/**
 * LeetCode 59 Spiral Matrix II
 */
class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }
        int[][] result = new int[n][n];
        int last = n * n;
        int start = 1;
        int l = 0,r = n - 1,t = 0,f = n - 1;
        while (start <= last) {
            for (int i = l; i <= r; i++) {
                result[t][i] = start++;
            }
            t++;
            for (int i = t; i <= f; i++) {
                result[i][r] = start++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                result[f][i] = start++;
            }
            f--;
            for (int i = f; i >= t; i--) {
                result[i][l] = start++;
            }
            l++;
        }
        return result;
    }
}
