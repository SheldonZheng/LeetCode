/**
 * LeetCode 384 Shuffle an Array
 */
class Solution {

        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            Random random = new Random();
            int[] res = nums.clone();
            for (int i = 0; i < nums.length; i++) {
                int j = i + random.nextInt(nums.length - i);
                int temp = res[i];
                res[i] = res[j];
                res[j] = temp;
            }
            return res;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
