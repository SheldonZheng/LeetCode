/**
 * LeetCode 887 Super Egg Drop
 * /
class Solution {
    public int superEggDrop(int K, int N) {
        int[][] memo = new int[K + 1][N + 1];

        return dp(K,N,memo);
    }

    public int dp(int K,int N,int[][] memo) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        if (memo[K][N] != 0) {
            return memo[K][N];
        }

        int res = Integer.MAX_VALUE;

      /*  for (int i = 1; i < N + 1; i++) {
            res = Math.min(res,Math.max(dp(K,N - i,memo),dp(K - 1,i - 1,memo)) + 1);
        }*/
        int lo = 1,hi = N;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int broken = dp(K - 1,mid - 1,memo);
            int notBroken = dp(K,N - mid,memo);
            if (broken > notBroken) {
                hi = mid - 1;
                res = Math.min(res,broken + 1);
            } else {
                lo = mid + 1;
                res = Math.min(res,notBroken + 1);
            }
        }
        memo[K][N] = res;
        return res;
    }
}
