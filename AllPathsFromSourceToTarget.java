/**
 * LeetCode 797 All Paths From Source to Target
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return res;
        }
        stack.offerLast(0);
        dfs(graph,0,graph.length - 1);
        return res;
    }

    public void dfs(int[][] graph,int x,int n) {
        if(x == n) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph,y,n);
            stack.pollLast();
        }
    }
}
