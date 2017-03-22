/**
 * @author Baiye
 * @since 2017-03-22
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int i = 0;
        int j = matrix[0].length - 1;

        while(i < matrix.length && j >= 0) {
            int n = matrix[i][j];
            if (target == n)
                return true;
            else if (target < n)
                j--;
            else
                i++;
        }
        return false;
    }
}
