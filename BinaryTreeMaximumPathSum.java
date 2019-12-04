/**
 * LeetCode 124 Binary Tree Maximum Path Sum
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
    //¸ºÊý
    private int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxValue(root);
        return result;
    }

    public int maxValue(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftVal = Math.max(maxValue(node.left),0);
        int rightVal = Math.max(maxValue(node.right),0);

        int newVal = leftVal + rightVal + node.val;

        result = Math.max(result,newVal);

        return node.val + Math.max(leftVal,rightVal);
    }
}
