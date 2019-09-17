/**
 * LeetCode 230 Kth Smallest Element in a BST
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int res;
    private int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        count--;
        if (count == 0) {
            this.res = root.val;
            return;
        }
        dfs(root.right);
    }
}
