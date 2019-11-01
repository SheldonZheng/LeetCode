/**
 * LeetCode 221 Maximal Square
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    int res = findMax(matrix, i, j);
                    max = Math.max(res, max);
                }
            }
        }
        return max * max;
    }

    private int findMax(char[][] matrix, int i, int j) {
        int cur = 1;
        boolean contiuneFlag = true;
        while (cur + i < matrix.length && cur + j < matrix[i].length && contiuneFlag) {
            for (int colRange = j; colRange <= cur + j; colRange++) {
                if (matrix[i + cur][colRange] == '0') {
                    contiuneFlag = false;
                    break;
                }
            }

            for (int rowRange = i; rowRange <= cur + i; rowRange++) {
                if (matrix[rowRange][j + cur] == '0') {
                    contiuneFlag = false;
                    break;
                }
            }

            if (contiuneFlag) {
                cur++;
            }

        }
        return cur;
    }
}
