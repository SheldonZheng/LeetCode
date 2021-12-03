/**
 * LeetCode 1005 Maximize Sum Of Array After K Negations
 */
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length;
        int idx = 0;
        PriorityQueue<Integer> container = new PriorityQueue<>((a,b) -> nums[a] - nums[b]);
        boolean containZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                container.add(i);
            }
            if (nums[i] == 0) {
                containZero = true;
            }
            if (Math.abs(nums[i]) < Math.abs(nums[idx])) {
                idx = i;
            }
        }

        if (k <= container.size()) {
            while (k > 0) {
                nums[container.peek()] = -nums[container.poll()];
                k--;
            }
        } else {
            while (!container.isEmpty() && k > 0) {
                nums[container.peek()] = -nums[container.poll()];
                k--;
            }
            if (!containZero && k % 2 != 0) {
                nums[idx] = -nums[idx];
            }
        }
        return Arrays.stream(nums).sum();
    }
}
