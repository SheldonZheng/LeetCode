/**
 * LeetCode Interview 01.07 Rotate Matrix LCCI
 */
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return ;
        }
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix[i].length - 1 - i][j];
                matrix[matrix[i].length - 1 - i][j] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return ;
    }
}
