/**
 * LeetCode 1854 Maximum Population Year
 */
class Solution {
    private final int offset = 1950;
    public int maximumPopulation(int[][] logs) {
        if (logs == null || logs.length == 0) {
            return 0;
        }
        int[] cnt = new int[101];
        for (int i = 0; i < logs.length; i++) {
            cnt[logs[i][0] - offset] += 1;
            cnt[logs[i][1] - offset] -= 1;
        }
        int cur = 0;
        int curMax = 0;
        int curIndex = 0;
        for (int i = 0; i <= 100; i++) {
            cur += cnt[i];
            if (cur > curMax) {
                curMax = cur;
                curIndex = i;
            }
        }
        return curIndex + offset;
    }
}
