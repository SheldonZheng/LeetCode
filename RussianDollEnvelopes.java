/**
 * LeetCode 354 Russian Doll Envelopes
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] hl = new int[envelopes.length];
        for (int i = 0; i < hl.length; i++) {
            hl[i] = envelopes[i][1];
        }
        return lic(hl);

    }

    private int lic(int[] hl) {
        int[] dp = new int[hl.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < hl.length; i++) {
            for (int j = 0; j < i; j++) {
                if (hl[j] < hl[i]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }

        int res = 1;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
