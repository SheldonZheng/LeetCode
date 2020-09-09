/**
 * LeetCode 39 Combination Sum
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || target == 0) {
            return result;
        }
        List<Integer> curList = new ArrayList<>();
        dfs(candidates,target,result,curList,0);
        return result;
    }

    private void dfs(int[] candidates, int remain,List<List<Integer>> result,List<Integer> curList,int pos) {
        if (pos == candidates.length) {
            return ;
        }

        if (remain == 0) {
            result.add(new ArrayList<>(curList));
            return ;
        }


        if (remain - candidates[pos] >= 0) {
            curList.add(candidates[pos]);
            dfs(candidates,remain - candidates[pos],result,curList,pos);
            curList.remove(curList.size() - 1);
        }
        
        dfs(candidates,remain,result,curList,pos + 1);

        return ;
    }
}
