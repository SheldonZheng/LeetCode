class Solution {
    int[] dire = {-1,0,1,0,-1};
    public int shortestPathAllKeys(String[] grid) {
        if (grid == null) {
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length();
        int sx = 0;
        int sy = 0;
        int keysNum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char v = grid[i].charAt(j);
                if (v == '@') {
                    sx = i;
                    sy = j;
                } else if (Character.isLowerCase(v)) {
                    keysNum++;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx,sy,0});
        boolean [][][] vis = new boolean[n][m][1 << keysNum];
        vis[sx][sy][0] = true;
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] poll = q.poll();
                int i = poll[0],j = poll[1],curKeys = poll[2];
                if (curKeys == (1 << keysNum) - 1) {
                    return res;
                }
                for (int p = 0; p < 4; p++) {
                    int x = i + dire[p];
                    int y = j + dire[p + 1];

                    if (x < 0 || x >= n || y < 0 || y >= m) {
                        continue;
                    }
                    char v = grid[x].charAt(y);
                    if (v == '#' || (Character.isUpperCase(v) && ((curKeys >> (v - 'A')) & 1) == 0)) {
                        continue;
                    }
                    int nxtKeys = curKeys;
                    if (Character.isLowerCase(v)) {
                        nxtKeys |= 1 << (v - 'a');
                    }

                    if (!vis[x][y][nxtKeys]) {
                        vis[x][y][nxtKeys] = true;
                        q.offer(new int[]{x,y,nxtKeys});
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
