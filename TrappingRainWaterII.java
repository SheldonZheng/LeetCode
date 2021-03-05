/**
 * LeetCode 407 Trapping Rain Water II
 */
class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) {
            return 0;
        }

        int n = heightMap.length;
        int m = heightMap[0].length;
        if (n < 2 || m < 2) {
            return 0;
        }

        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        int res = 0;

        int[][] visited = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[2] - o2[2]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = 1;
                }
            }
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dirs[k][0];
                int ny = cur[1] + dirs[k][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] != 1) {
                    if (cur[2] > heightMap[nx][ny]) {
                        res += cur[2] - heightMap[nx][ny];
                    }
                    pq.offer(new int[]{nx,ny,Math.max(heightMap[nx][ny],cur[2])});
                    visited[nx][ny] = 1;
                }
            }
        }

        return res;
    }
}
