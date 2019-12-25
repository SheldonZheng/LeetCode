/**
 * LeetCode 378 Kth Smallest Element in a Sorted Matrix
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[maxRow - 1][maxCol - 1];

        while (left < right) {
            int mid = (left + right) / 2;
            int count = countNotBiggerThanMid(maxRow,maxCol,mid,matrix);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public int countNotBiggerThanMid(int maxRow,int maxCol,int mid,int[][] matrix) {
        int col = 0;
        int row = maxRow - 1;
        int result = 0;
        while (col < maxCol && row >= 0) {
            if (matrix[row][col] <= mid) {
                result += (row + 1);
                col++;
            } else {
                row--;
            }
        }
        return result;
    }
}
