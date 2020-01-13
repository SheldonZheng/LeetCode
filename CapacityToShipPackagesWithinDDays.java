/**
 * LeetCode 1011 Capacity To Ship Packages Within D Days
 */
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int lo = 0,hi = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights,D,mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public boolean canShip(int[] weights,int D, int K) {
        int cur = K;
        for (int weight : weights) {
            if (weight > K) {
                return false;
            }
            //reset
            if (cur < weight) {
                cur = K;
                D--;
                if (D < 0) {
                    return false;
                }
            }
            cur -= weight;
        }
        return D > 0;
    }
}
