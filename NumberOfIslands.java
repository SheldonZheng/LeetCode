/**
 * LeetCode 200 Number of Islands
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        //int[][] data = new int[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i,int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return ;
        }
        if (grid[i][j] == '0') {
            return ;
        }

        grid[i][j] = '0';

        dfs(grid,i + 1,j);
        dfs(grid,i - 1,j);
        dfs(grid,i,j + 1);
        dfs(grid,i,j - 1);

        return ;
    }
}
