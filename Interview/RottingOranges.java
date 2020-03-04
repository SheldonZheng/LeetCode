/**
 * LeetCode 994 Rotting Oranges
 */
class Solution {
    private static  final int[] dr = new int[]{-1,0,1,0};
    private static final int[] dc = new int[]{0,1,0,-1};

    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int R = grid.length;
        int C = grid[0].length;
        int count = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Map<Integer,Integer> container = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    int code = i * C + j;
                    queue.add(code);
                    container.put(code,0);
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.poll();
            int r = code / C;
            int c = code % C;
            for (int time = 0; time < 4; time++) {
                int nr = r + dr[time];
                int nc = c + dc[time];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    count--;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    int nv = container.get(code) + 1;
                    container.put(ncode,nv);
                    ans = nv;
                }
            }
        }
        if (count == 0) {
            return ans;
        } else {
            return -1;
        }

    }
}
