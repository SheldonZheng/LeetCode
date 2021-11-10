/**
 * LeetCode 495 Teemo Attacking
 */
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i] + duration >= timeSeries[i + 1]) {
                res += timeSeries[i + 1] - timeSeries[i];
            } else {
                res += duration;
            }
        }
        res += duration;
        return res;
    }
}
