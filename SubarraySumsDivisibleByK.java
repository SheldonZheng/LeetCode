/**
 * LeetCode 974 Subarray Sums Divisible by K
 */
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        if (A == null || K < 0) {
            return -1;
        }
        Map<Integer,Integer> container = new HashMap<>();
        container.put(0,1);
        int preSum = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            preSum = (preSum + A[i]) % K;
            if (preSum < 0) {
                preSum += K;
            }
            if (container.containsKey(preSum)) {
                count += container.get(preSum);
                container.put(preSum,container.get(preSum) + 1);
            } else {
                container.put(preSum,1);
            }
        }
        return count;
    }
}
