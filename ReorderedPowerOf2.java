/**
 * LeetCode 869 Reordered Power of 2
 */
class Solution {
    boolean[] vis;

    public boolean reorderedPowerOf2(int n) {
        if (n == 0) {
            return false;
        }
        char[] nums = Integer.toString(n).toCharArray();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        return backtrack(nums,0,0);
    }

    public boolean backtrack(char[] nums,int idx,int num) {
        if (idx == nums.length) {
            return isPowerOfTwo(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if ((num == 0 && nums[i] == '0') || vis[i] || (i > 0 && !vis[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            vis[i] = true;
            if (backtrack(nums,idx + 1,num * 10 + nums[i] - '0')) {
                return true;
            }
            vis[i] = false;
        }
        return false;
    }

    public boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
}
