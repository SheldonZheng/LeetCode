/**
 * LeetCode 983 Minimum Cost For Tickets
 */
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int maxDay = days[len - 1];
        int minDay = days[0];
        int[] dp = new int[365 + 31];
        Set<Integer> container = new HashSet<>();
        for (int day : days) {
            container.add(day);
        }
        int i = len - 1;
        for (int day = maxDay; day >= minDay; day--) {
            if (container.contains(day)) {
                dp[day] = Math.min(Math.min(dp[day + 1] + costs[0],dp[day + 7] + costs[1]),dp[day + 30] + costs[2]);
            } else {
                dp[day] = dp[day + 1];
            }
        }
        return dp[minDay];
    }
}
