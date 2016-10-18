package BinaryTree;

/**
 * Created by Baiye on 2016/10/18.
 */

/**
 * LeetCode.235. Lowest Common Ancestor of a Binary Search Tree
 * 原题地址:https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 基于BST树的特点，判断LCA节点再当前root节点的左边还是右边，不管左边右边都递归下去，如果都不，那就是当前root节点；
 */
public class LCAofABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null)
            return null;

        if(Math.max(p.val,q.val) < root.val)
            return lowestCommonAncestor(root.left,p,q);
        else if(Math.min(p.val,q.val) > root.val)
            return lowestCommonAncestor(root.right,p,q);
        else
            return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

