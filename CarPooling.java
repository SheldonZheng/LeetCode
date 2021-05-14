/**
 * LeetCode 1094 Car Pooling
 */
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0 || capacity == 0) {
            return false;
        }
        int[] distanceContainer = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            distanceContainer[trips[i][1]] += trips[i][0];
            distanceContainer[trips[i][2]] -= trips[i][0];
        }
        int cur = 0;
        for (int i = 0; i < distanceContainer.length; i++) {
            cur += distanceContainer[i];
            if (cur > capacity) {
                return false;
            }
        }
        return true;
    }
}
