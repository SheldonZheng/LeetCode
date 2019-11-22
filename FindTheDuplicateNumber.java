/**
 * LeetCode 287 Find the Duplicate Number
 */
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> container = new HashSet<>();
        for (int num : nums) {
            if (container.contains(num)) {
                return num;
            }
            container.add(num);
        }
        return -1;
    }
}
