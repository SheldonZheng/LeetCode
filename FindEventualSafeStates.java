/**
 * LeetCode 802 Find Enentual Safe States
 */
class Solution {
    public int[] mark;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return res;
        }
        mark = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (isSafe(graph,i)) {
                res.add(i);
            }
        }
        return res;

    }

    public boolean isSafe(int[][] graph,int x) {
        if (mark[x] > 0) {
            return mark[x] == 2;
        }
        mark[x] = 1;
        for (int i : graph[x]) {
            if (!isSafe(graph,i)) {
                return false;
            }
        }
        mark[x] = 2;
        
        return true;
    }
}
