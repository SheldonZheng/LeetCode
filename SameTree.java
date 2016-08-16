/**
 * Created by Baiye on 2016/8/16.
 */

/**
 * LeetCode 100 Same Tree
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.



 */


public class SameTree {


    public boolean isSameTree(TreeNode p, TreeNode q) {

        return (p == null && q == null) || ((p != null &&q != null && p.val == q.val) && (isSameTree(p.left,q.left) && isSameTree(p.right,q.right)));


       /* if(p == null && q == null)
            return true;

        else if(p == null && q != null)
            return false;

        else if(p != null && q == null)
            return false;

        else if(p != null && q != null && p.val != q.val)
            return false;

        else
            return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));*/
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
