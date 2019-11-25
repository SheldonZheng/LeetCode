/**
 * LeetCode 239 Sliding Window Maximum
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        //init
        int maxId = 0;
        for (int i = 0; i < k; i++) {
            cleanQueue(i,k,queue,nums);
            queue.addLast(i);
            if (nums[i] > nums[maxId]) {
                maxId = i;
            }
        }
        result.add(nums[maxId]);
        for (int i = k; i < nums.length; i++) {
            cleanQueue(i,k,queue,nums);
            queue.addLast(i);
            result.add(nums[queue.getFirst()]);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private void cleanQueue(int i,int k,ArrayDeque<Integer> queue,int[] nums) {
        if (!queue.isEmpty() && queue.getFirst() == i - k) {
            queue.removeFirst();
        }
        while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
            queue.removeLast();
        }
    }
}
