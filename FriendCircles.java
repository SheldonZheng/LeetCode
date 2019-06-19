/**
 * LeetCode 547 Friend Circles
 */
class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null) {
            return 0;
        }
        int[] auth = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (auth[i] == 0) {
                dfs(M,auth,i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M,int[] auth,int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && auth[j] == 0) {
                auth[j] = 1;
                dfs(M,auth,j);
            }
        }
    }
}
