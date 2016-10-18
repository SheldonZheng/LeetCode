package BinaryTree;

/**
 * Created by Baiye on 2016/8/9.
 */
/*
 * LeetCode 104题 给出一个二叉树，计算最深的叶子节点距离根节点的距离；
 * 递归解决，如果传入值为null直接return 0；如果不，左右节点分别递归下去，取大值加一得出结果；
 */
public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        int leftCount = maxDepth(root.left);
        int rightCount = maxDepth(root.right);

        return leftCount > rightCount ? leftCount + 1 : rightCount + 1;

        /*
         * 更简单的方式： "return Math.max(maxDepth(root.left),maxDepth(root.right));"  因为LeetCode不支持调用JDK的类库，所以只能这么写；
         */
    }


     private class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
}
