/**
 * LeetCode 1572 Matrix Diagonal Sum
 * /
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int mid = n / 2;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += (mat[i][i] + mat[i][n - i - 1]);
        }
        return n % 2 == 0 ? res : res - mat[mid][mid];
    }
}
