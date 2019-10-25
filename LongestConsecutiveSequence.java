/**
 * LeetCode 128 Longest Consecutive Sequence
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        Set<Integer> container = new HashSet<>();
        for (int num : nums) {
            container.add(num);
        }
        for (int num : nums) {
            if (!container.contains(num - 1)) {
                int t = 0;
                int c = num;
                while (container.contains(c)) {
                    t++;
                    c++;
                }
                result = Math.max(result,t);
            }
        }
        return result;
    }
}
