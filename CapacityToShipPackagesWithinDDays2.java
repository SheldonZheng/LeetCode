/**
 * LeetCode 1011 Capacity To Ship Packages Within D Days
 */
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0) {
            return 0;
        }
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 1;
            int cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    count++;
                    cur = 0;
                }
                cur += weight;
            }
            if (count <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
