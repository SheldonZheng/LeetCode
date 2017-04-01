package DP;

/**
 * @author Baiye
 * @since 2017-04-01
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int [][]temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0;j < n;j++) {
                temp[i][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1;j < n;j++) {
                temp[i][j] = temp[i - 1][j] + temp[i][j - 1];
            }
        }

        return temp[m -1][n - 1];
    }
}
