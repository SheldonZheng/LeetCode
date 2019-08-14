/**
 * LeetCode 98 Validate Binary Search Tree
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
     public boolean isValidBST(TreeNode root) {
        return search(root,null,null);

    }

    public boolean search(TreeNode cu,Integer l,Integer h) {
        if (cu == null) {
            return true;
        }

        if (l != null && cu.val <= l) {
            return false;
        }
        if (h != null && cu.val >= h) {
            return false;
        }

        if (!search(cu.right,cu.val,h)) {
            return false;
        }
        if (!search(cu.left,l,cu.val)) {
            return false;
        }

        return true;
    }
}
