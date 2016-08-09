/**
 * Created by Baiye on 2016/8/9.
 */

/**
 * LeetCode 111 求一个二叉树最小深度  参考最大深度解法，需要处理的特殊情况是当此节点的左节点或者右节点为0时，取另外一边的结果+1返回；
 */
public class MinDepthOfBinaryTree {


    public int minDepth(TreeNode root) {

        if(root == null)
            return 0;

        int leftCount = minDepth(root.left);
        int rightCount = minDepth(root.right);

        if(leftCount == 0)
            return rightCount + 1;
        if(rightCount == 0)
            return leftCount + 1;

        return leftCount > rightCount ? rightCount + 1 : leftCount + 1;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
