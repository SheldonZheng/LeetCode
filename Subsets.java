/**
 * LeetCode 78 Subsets
 */
class Solution {
    private void backtrack(int cur, int []nums,List<Integer> numList, List<List<Integer>> result) {
        result.add(new ArrayList<>(numList));
        for (int i = cur; i < nums.length; i++) {
            numList.add(nums[i]);
            backtrack(i + 1,nums,numList,result);
            numList.remove(numList.size() - 1);
        }
        return ;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> container = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        backtrack(0,nums,container,result);
        return result;
    }
}
