/**
 * LeetCode 55 Jump Game
 */
class Solution {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }
        memo[nums.length - 1] = 1;
        return backtrack(memo,0,nums);
    }

    public boolean backtrack(int[] memo,int pos ,int[] nums) {
        if (pos == nums.length - 1) {
            return true;
        }
        if (memo[pos] == 1) {
            return true;
        }
        if (memo[pos] == 2) {
            return false;
        }


        int maxPos = Math.min(pos + nums[pos],nums.length - 1);
        for (int i = maxPos; i > pos; i--) {
            if (backtrack(memo,i,nums)) {
                memo[pos] = 1;
                return true;
            }
        }
        memo[pos] = 2;
        return false;
    }
}
