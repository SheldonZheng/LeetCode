/**
 * LeetCode 46 Permutations
 */
class Solution {
    private void backtrack(int maxLength, int cur,List<Integer> nums, List<List<Integer>> result) {
        if (maxLength == cur) {
            result.add(new ArrayList<>(nums));
            return ;
        }
        for (int i = cur; i < maxLength; i++) {
            Collections.swap(nums,cur,i);
            backtrack(maxLength, cur + 1, nums, result);
            Collections.swap(nums,cur,i);
        }
        return ;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> container = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int num : nums) {
            container.add(num);
        }
        backtrack(nums.length,0,container,result);
        return result;
    }
}
