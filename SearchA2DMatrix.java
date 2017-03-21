/**
 * @author Baiye
 * @since 2017-03-21
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m*n -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int tmp = matrix[mid/n][mid%n];
            if (tmp > target) {
                end = mid - 1;
                continue;
            }
            if (tmp < target) {
                start = mid + 1;
                continue;
            }
            return true;
        }
        return false;
    }
}
