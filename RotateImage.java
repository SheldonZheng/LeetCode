/**
 * LeetCode 48 Rotate Image
 */
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return ;
        }
        int l = matrix.length;

        //1
        //-270
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //2
        //+180
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][l - 1 - j];
                matrix[i][l - 1 - j] = temp;
            }
        }
        return;
    }
}
