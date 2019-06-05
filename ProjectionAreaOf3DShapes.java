//LeetCode 883
class Solution {
    public int projectionArea(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int z = 0,x = 0,y = 0;
        for (int i = 0; i < grid.length; ++i) {
            int mx = 0,my = 0;
            for (int j = 0; j < grid.length; ++j) {
                mx = Math.max(mx,grid[j][i]);
                my = Math.max(my,grid[i][j]);
                if (grid[i][j] > 0) {
                    ++z;
                }
            }
            x += mx;
            y += my;
        }

        return x + y + z;
    }
}
