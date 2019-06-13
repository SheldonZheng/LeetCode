/**
 * LeetCode 695 Max Area of Island
 */
public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int r = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int num = search(grid, i, j);
                    r = Math.max(r, num);
                }
            }
        }
        return r;
    }

    public int search(int[][] grid,int i,int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1) {
            //no repeat
            grid[i][j] = 0;
            int num = 1 + search(grid,i + 1,j) + search(grid , i - 1,j) + search(grid,i,j + 1) + search(grid,i, j - 1);
            return num;
        } else {
            return 0;
        }
    }
