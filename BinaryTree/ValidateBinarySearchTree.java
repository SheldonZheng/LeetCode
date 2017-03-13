package BinaryTree;

/**
 * @author Baiye
 * @since 2017-03-13
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        return lessThan(root.left,root.val) && greatThan(root.right,root.val) && isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean lessThan(TreeNode node,int val) {
        if(node == null)
            return true;
        return node.val < val && lessThan(node.left,val) && lessThan(node.right,val);
    }

    public boolean greatThan(TreeNode node,int val) {
        if(node == null)
            return true;

        return node.val > val && greatThan(node.left,val) && greatThan(node.right,val);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
