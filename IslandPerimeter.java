//LeetCode 463
class Solution {
      public static int islandPerimeter(int[][] grid) {
        if (null == grid) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        result++;
                    }
                    if (j == 0) {
                        result++;
                    }
                    if (j > 0 && grid[i][j - 1] == 0) {
                        result++;
                    }
                    if (j == grid[i].length - 1 || grid[i][j + 1] == 0) {
                        result++;
                    }
                    if (i > 0 && grid[i - 1][j] == 0) {
                        result++;
                    }
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
