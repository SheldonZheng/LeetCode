/**
 * LeetCode 236 Lowest Common Ancestor of a Binary Tree
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
    TreeNode result = null;

    private boolean findNode(TreeNode root,TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        if (this.result != null) {
            return false;
        }

        int left = findNode(root.left ,p,q) ? 1 : 0;

        int right = findNode(root.right ,p,q) ? 1 : 0;

        int mid = (root == q || root == p) ? 1 : 0;

        if ((mid + left + right) >= 2) {
            this.result = root;
        }

        return (mid + left + right) > 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root,p,q);
        return this.result;
    }
}
