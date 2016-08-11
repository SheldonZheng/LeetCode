/**
 * Created by Baiye on 2016/8/11.
 */
/**
 * 给入一个二叉树，判断这个二叉树是不是平衡二叉树，返回true或者false。我在做这道题的时候只看了第一行，没看下面关于平衡二叉树的定义。
 * 走了一点弯路。我起初认为平衡二叉树是要求如果左节点不为空那么右节点也不能为空，反之也如此。
 * 其实平衡二叉树的定义是两个子节点的高度差不能大于一。那么我们就要实现一个计算二叉树深度的函数，然后比较结果就好了。
 * 代码如下：

 */

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if(root == null)
            return true;

        int leftCount = maxDepth(root.left);
        int rightCount = maxDepth(root.right);

        if(leftCount > rightCount + 1 || rightCount > leftCount + 1)
            return false;

        return (isBalanced(root.left) && isBalanced(root.right));
    }

    public int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;

        int leftCount = maxDepth(root.left);
        int rightCount = maxDepth(root.right);

        return leftCount > rightCount ? leftCount + 1 : rightCount + 1;


    }




    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
