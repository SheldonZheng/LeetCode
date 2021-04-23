/**
 * LeetCode 368 Largest Divisible Subset
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] container = new int[n];

        for (int i = 0; i < n; i++) {
            int curLen = 1;
            int prev = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > curLen) {
                        curLen = dp[j] + 1;
                        prev = j;
                    }
                }
            }
            dp[i] = curLen;
            container[i] = prev;
        }

        int max = -1;
        int lastIndex = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                lastIndex = i;
                max = dp[i];
            }
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < max) {
            res.add(nums[lastIndex]);
            lastIndex = container[lastIndex];
        }

        return res;
    }
}
