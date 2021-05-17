/**
 * LeetCode 993 Cousins in Binary Tree
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
    private int xDep = 0;
    private int yDep = 0;
    private int xParentVal = -1;
    private int yParentVal = -1;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        find(root,x,y,0);
        if (xDep == yDep && xParentVal != yParentVal) {
            return true;
        } else {
            return false;
        }
    }

    private void find(TreeNode root, int x, int y,int cur) {
        if (root == null) {
            return ;
        }
        if (root.left != null) {
            if (root.left.val == x) {
                xDep = cur + 1;
                xParentVal = root.val;
            } else if (root.left.val == y) {
                yDep = cur + 1;
                yParentVal = root.val;
            }
        }
        if (root.right != null) {
            if (root.right.val == x) {
                xDep = cur + 1;
                xParentVal = root.val;
            } else if (root.right.val == y) {
                yDep = cur + 1;
                yParentVal = root.val;
            }
        }
        find(root.left,x,y,cur + 1);
        find(root.right,x,y,cur + 1);
        return ;
    }
}
