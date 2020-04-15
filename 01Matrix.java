/**
 * LeetCode 542 01 Matrix
 */
class Solution {

    int[][] dr = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        boolean[][] visted = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                    visted[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            int x = location[0],y = location[1];
            for (int[] move : dr) {
                int newX = x + move[0];
                int newY = y + move[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || visted[newX][newY]) {
                    continue;
                }
                res[newX][newY] = res[x][y] + 1;
                visted[newX][newY] = true;
                queue.offer(new int[]{newX,newY});
            }
        }
        return res;
    }
}
