/**
 * LeetCode 671 Second Minimum Node in a Binary Tree
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
    int res = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root,root.val);
        return res;
    }

    public void dfs(TreeNode root,int cur) {
        if (root == null) {
            return ;
        }
        if (root.val != cur) {
            if (res == -1) {
                res = root.val;
            } else {
                res = Math.min(res,root.val);
            }
        }
        dfs(root.left,cur);
        dfs(root.right,cur);
    }
}
