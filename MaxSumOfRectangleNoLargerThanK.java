/**
 * LeetCode 363 Max Sum of Rectangle No Larger Than K
 */
class Solution {
    public int maxSumSubmatrix(int[][] matrix,int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < cols; l++) {
            int[] rowSum = new int[rows];
            for (int r = l; r < cols; r++) {
                for (int i = 0; i < rowSum.length; i++) {
                    rowSum[i] += matrix[i][r];
                }

                max = Math.max(max,arrayMax(rowSum,k));
            }
        }
        return max;
    }

    private int arrayMax(int[] arr,int k) {
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
