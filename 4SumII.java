/**
 * LeetCode 454 4Sum II
 */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null) {
            return 0;
        }
        Map<Integer,Integer> container = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (container.containsKey(sum)) {
                    container.put(sum,container.get(sum) + 1);
                } else {
                    container.put(sum,1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = 0 - C[i] - D[j];
                if (container.containsKey(sum)) {
                    res += container.get(sum);
                }
            }
        }
        return res;
    }
}
