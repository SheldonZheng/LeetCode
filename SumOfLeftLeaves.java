/**
 * LeetCode 404 Sum of Left Leaves
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
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelper(root,false);
    }

    public int sumOfLeftLeavesHelper(TreeNode root,boolean flag) {
        if (root == null) {
            return 0;
        }
        if (flag && root.left == null && root.right == null) {
            return root.val;
        }
        int left = sumOfLeftLeavesHelper(root.left,true);
        int right = sumOfLeftLeavesHelper(root.right,false);
        return left + right;
    }
}
