/**
 * LeetCode 219 Contains Duplicate II
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> container = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (container.contains(nums[i])) {
                return true;
            }
            container.add(nums[i]);
            if (container.size() > k) {
                container.remove(nums[i - k]);
            }
        }

        return false;
    }
}
