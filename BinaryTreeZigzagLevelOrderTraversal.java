/**
 * Created by Baiye on 2016/8/19.
 */

import java.util.*;

/**
 * LeetCode.103.Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * 给入一个二叉树，通过Zig-Zag遍历返回一个二层的List；
 *
 * 思路是构造一个队列，先放入root节点，第一次遍历把root节点的左右节点放进去，下一次遍历就是root节点的左右节点的子节点……依次类推；
 * 因为是Zig-Zag遍历，所以放置一个flag来判断是不是要翻转结果；
 * 注意开头的root==null的判断；
 */

public class BinaryTreeZigzagLevelOrderTraversal {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int flag = -1;
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.peek() != null)
        {
            flag = 0 - flag;
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
            if(flag == -1)
                Collections.reverse(list);
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
