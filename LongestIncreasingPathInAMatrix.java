/**
 * LeetCode 329 Longest Increasing Path in a Matrix
 */
class Solution {
    private static final int[][] paths = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int res = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res = Math.max(res,dfs(i,j,matrix,cache));
            }
        }
        return res;
    }

    private int dfs(int i,int j,int[][] matrix,int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        for (int[] path : paths) {
            int x = i + path[0];
            int y = j + path[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[i].length && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j],dfs(x,y,matrix,cache));
            }
        }
        return ++cache[i][j];
    }
}
