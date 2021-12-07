/**
 * LeetCode 1034 Coloring A Border
 */
class Solution {
    int m;
    int n;
    int c;
    int[][] grid,res;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int[][] colorBorder(int[][] _grid, int row, int col, int color) {
        m = _grid.length;
        n = _grid[0].length;
        res = new int[m][n];
        grid = _grid;
        c = color;
        dfs(row,col);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == 0) {
                    res[i][j] = grid[i][j];
                }
            }
        }
        return res;
    }

    void dfs(int x,int y) {
        int cnt = 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (grid[x][y] != grid[nx][ny]) {
                continue;
            } else {
                cnt++;
            }
            if (res[nx][ny] == -1) {
                continue;
            }
            res[nx][ny] = -1;
            dfs(nx,ny);
        }
        res[x][y] = cnt == 4 ? grid[x][y] : c;
    }
}
