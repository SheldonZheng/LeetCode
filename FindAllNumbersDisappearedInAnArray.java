/**
 * LeetCode 448 Find All Numbers Disappeared in an Array
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int targetIndex = Math.abs(nums[i]) - 1;

            if (nums[targetIndex] > 0) {
                nums[targetIndex] *= -1;
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                res.add(i);
            }
        }
        return res;
    }
}
