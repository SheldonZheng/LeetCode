/**
 * LeetCode 41 First Missing Positive
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        Set<Integer> container = new HashSet<>();
        for (int num : nums) {
            container.add(num);
        }
        int cur = 1;
        while (container.contains(cur)) {
            cur++;
        }
        return cur;
    }
}
