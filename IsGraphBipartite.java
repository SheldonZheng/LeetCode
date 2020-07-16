/**
 * LeetCode 785 Is Graph Bipartite
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        try {
            for (int i = 0; i < n; i++) {
                if (color[i] == 0) {
                    dfs(i, 1, graph, color);
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void dfs(int i, int c, int[][] graph, int[] color) throws Exception {
        color[i] = c;
        int revers = c == 1 ? 2 : 1;
        for (int j : graph[i]) {
            if (color[j] == 0) {
                dfs(j, revers, graph, color);
            } else if (color[j] != revers) {
                throw new Exception("false");
            }
        }
    }
}
