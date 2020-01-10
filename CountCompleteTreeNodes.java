/**
 * LeetCode 222 Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        return search(root);
    }

    public int search(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return search(root.left) + search(root.right) + 1;
    }
}
