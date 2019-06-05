//LeetCode 375
class Solution {
    public int getMoneyAmount(int n) {
        if (n < 1) {
            return 0;
        }
        int[][] table = new int[n + 1][n + 1];
        return DP(table,1,n);
    }

    public int DP(int[][] t ,int start , int end) {
        if (start >= end) {
            return 0;
        }
        if (t[start][end] != 0) {
            return t[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int r = i + Math.max(DP(t,start,i - 1),DP(t,i + 1,end));
            res = Math.min(r,res);
        }
        t[start][end] = res;
        return res;
    }
}
