/**
 * LeetCode 815 Bus Routes
 */
class Solution {
        public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        if (routes == null || routes.length == 0) {
            return -1;
        }
        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        Map<Integer, List<Integer>> container = new HashMap<>();
        for (int i = 0;i < n;i++) {
            for (int curSite : routes[i]) {
                List<Integer> curList = container.getOrDefault(curSite,new ArrayList<Integer>());
                for (int j : curList) {
                    edge[i][j] = edge[j][i] = true;
                }
                curList.add(i);
                container.put(curSite,curList);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis,-1);
        Queue<Integer> que = new LinkedList<Integer>();
        if (container.containsKey(source)) {
            for (int curSite : container.get(source)) {
                dis[curSite] = 1;
                que.offer(curSite);
            }
        }
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y = 0;y < n;y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    que.offer(y);
                }
            }
        }
        if (container.containsKey(target)) {
            int res = Integer.MAX_VALUE;
            for (int curSite : container.get(target)) {
                if (dis[curSite] != -1) {
                    res = Math.min(res,dis[curSite]);
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        } else {
            return -1;
        }

    }
}
