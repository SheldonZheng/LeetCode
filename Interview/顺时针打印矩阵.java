/**
 * LeetCode 面试题 29 顺时针打印矩阵
 */
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int u = 0;
        int d = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        while (1 == 1) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }
            u++;
            if (u > d) {
                break;
            }
            for (int i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }
            r--;
            if (r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res.add(matrix[d][i]);
            }
            d--;
            if (d < u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                res.add(matrix[i][l]);
            }
            l++;
            if (l > r) {
                break;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
