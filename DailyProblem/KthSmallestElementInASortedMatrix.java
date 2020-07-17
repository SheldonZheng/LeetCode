/**
 * LeetCode 378 Kth Smallest Element in a Sorted Matrix
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (right + left) / 2;
            int count = countNotBiggerThanMid(matrix,mid);
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int countNotBiggerThanMid(int[][] matrix,int mid) {
        int i = matrix.length - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < matrix.length) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num;
    }
}
