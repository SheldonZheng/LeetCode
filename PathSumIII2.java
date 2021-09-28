/**
 * LeetCode 437 Path Sum III
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Map<Integer,Integer> prefix = new HashMap<>();
        prefix.put(0,1);
        return dfs(root,prefix,0,targetSum);
    }

    public int dfs(TreeNode root, Map<Integer,Integer> prefix, int cur, int targetSum) {
        if (root == null) {
            return 0;
        }
        int curRes = 0;
        cur += root.val;

        curRes += prefix.getOrDefault(cur - targetSum,0);
        prefix.put(cur,prefix.getOrDefault(cur,0) + 1);
        curRes += dfs(root.left,prefix,cur,targetSum);
        curRes += dfs(root.right,prefix,cur,targetSum);
        prefix.put(cur,prefix.getOrDefault(cur,0) - 1);

        return curRes;
    }
}
