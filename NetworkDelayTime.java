/**
 * LeetCode 743 Network Delay Time
 */
class Solution {
    public int networkDelayTime(int[][] times,int n,int k) {
        if (times == null || times.length == 0) {
            return 0;
        }
        int MAX = Integer.MAX_VALUE / 2;
        int[][] grap = new int[n][n];
        for (int i = 0; i < grap.length; i++) {
            Arrays.fill(grap[i],MAX);
        }

        //fill
        for (int[] time : times) {
            grap[time[0] - 1][time[1] - 1] = time[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist,MAX);
        dist[k - 1] = 0;
        boolean[] visted = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int y = 0; y < n; y++) {
                if (!visted[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            for (int y = 0; y < n; y++) {
                dist[y] = Math.min(dist[y],dist[x] + grap[x][y]);
            }
            visted[x] = true;
        }

        int res = Arrays.stream(dist).max().getAsInt();
        return res == MAX ? -1 : res;

    }
}
