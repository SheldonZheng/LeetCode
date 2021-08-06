/** 
 * LeetCode 847 Shortest Path Visiting All Nodes
 */
class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return 0;
        }
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i,1 << i,0});
            visited[i][1 << i] = true;
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0],mask = cur[1],dist = cur[2];
            if (mask == (1 << n) - 1) {
                res = dist;
                break;
            }
            for (int j : graph[u]) {
                int nextMask = mask | (1 << j);
                if (!visited[j][nextMask]) {
                    queue.offer(new int[]{j,nextMask,dist + 1});
                    visited[j][nextMask] = true;
                }
            }
        }
        return res;
    }
}
