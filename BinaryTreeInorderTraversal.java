/**
 * Created by Baiye on 2016/8/18.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode.94 Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * 二叉树的中序遍历。就是先遍历左节点，再中节点，最后右节点；
 * 题目要求最好不要使用递归，递归在这里是最简单的写法，但是耗时以及消耗空间都很高，一旦传入二叉树过深，容易爆栈。
 * 这里使用循环的方法解题，空间复杂度为O(h)，h为二叉树的高度；
 * 先构建一个栈，一直遍历到最左边的节点，把所有的最左侧节点压栈，遍历到最后以后从栈里取值，继续遍历右节点；
 *
 */

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stk = new Stack<>();

        TreeNode p = root;

        while (p != null || !stk.empty())
        {
            if(p != null)
            {
                stk.push(p);
                p = p.left;
            }
            else
            {
                p = stk.pop();
                result.add(p.val);
                p = p.right;
            }
        }

        return result;
    }

    private class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }
}
