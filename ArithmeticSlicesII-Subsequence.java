/**
 * LeetCode 446 Arithmetic Slices II - Subsequence
 */
public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int n = nums.length;
        Map<Long,Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = nums[i] - nums[j];
                dp[i].put(diff,dp[i].getOrDefault(diff,0) + dp[j].getOrDefault(diff,0) + 1);

                if (dp[j].containsKey(diff)) {
                    res += dp[j].get(diff);
                }
            }
        }
        return res;
    }
