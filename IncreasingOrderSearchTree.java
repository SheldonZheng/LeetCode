/**
 * LeetCode 897 Increasing Order Search Tree
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
    TreeNode res = new TreeNode(-1);

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = res;
        inorder(root);
        return newRoot.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return ;
        }
        inorder(node.left);

        res.right = node;
        node.left = null;
        res = res.right;

        inorder(node.right);
        return ;
    }
}
