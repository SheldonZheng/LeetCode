package BinaryTree; /**
 * Created by Baiye on 2016/8/19.
 */

import java.util.*;

/**
 *
 * LeetCode.102.Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 2019/08/21
 * 很简单的层级顺序遍历，思路是构造一个队列，先放入root节点，第一次遍历把root节点的左右节点放进去，下一次遍历就是root节点的左右节点的子节点……依次类推；
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.peek() != null)
        {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i < size;i++)
            {
                TreeNode p = queue.poll();
                list.add(p.val);
                if(p.left != null)
                    queue.add(p.left);
                if(p.right != null)
                    queue.add(p.right);
            }
            result.add(list);
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
