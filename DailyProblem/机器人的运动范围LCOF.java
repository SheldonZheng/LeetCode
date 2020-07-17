/**
 * LeetCode Interview 13 机器人的运动范围 LCOF
 */
class Solution {
    public int movingCount(int m, int n, int k) {
        if (k < 0 || m < 0 || n < 0) {
            return 0;
        }
        return dfs(0,0,0,0,m,n,k,new boolean[m][n]);
    }

    public int dfs(int i,int j,int si,int sj,int m,int n,int k,boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1,j,(i + 1) % 10 != 0 ? si + 1 : si - 8,sj,m,n,k,visited) + dfs(i ,j + 1,si,(j + 1) % 10 != 0 ? sj + 1 : sj - 8,m,n,k,visited);
    }
}
