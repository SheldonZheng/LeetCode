/**
 * LeetCode 437 Path Sum III
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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return countPath(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }

    public int countPath(TreeNode root,int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum - root.val;
        return (sum == 0 ? 1 : 0) + countPath(root.left,sum) + countPath(root.right,sum);
    }
}
