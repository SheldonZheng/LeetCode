/**
 * LeetCode 104 Maximum Depth of Binary Tree
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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftCount = maxDepth(root.left);
        int rightCount = maxDepth(root.right);

        return leftCount > rightCount ? leftCount + 1 : rightCount + 1;
    }
}
