/**
 * Created by Baiye on 2016/8/10.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {

        if(root == null)
            return root;
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;

        return root;
    }




      private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
}
