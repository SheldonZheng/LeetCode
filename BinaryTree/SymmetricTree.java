package BinaryTree;

/**
 * Created by Baiye on 2016/11/4.
 */

/**
 * LeetCode.101.Symmetric Tree
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSame(root.left,root.right);
    }

    public boolean isSame(TreeNode left,TreeNode right)
    {
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        return isSame(left.left,right.right) && isSame(left.right,right.left);
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
