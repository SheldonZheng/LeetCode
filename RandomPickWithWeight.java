/**
 * LeetCode 528 Random Pick with Weight
 */
class Solution {

        int[] preSum;
        int total;

        public Solution(int[] w) {
            preSum = new int[w.length];
            preSum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                preSum[i] = preSum[i - 1] + w[i];
            }
            total = Arrays.stream(w).sum();
        }

        public int pickIndex() {
            return binarySearch((int) (Math.random() * total) + 1);
        }

        public int binarySearch(int target) {
            int l = 0,r = preSum.length - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (preSum[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
