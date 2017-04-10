package List;

/**
 * Created by Baiye on 10/04/2017.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TTL(root);
    }

    public TreeNode TTL (TreeNode root) {
        if (root == null)
            return null;
        TreeNode right = TTL(root.right);
        root.right = TTL(root.left);
        root.left = null;
        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;
        return root;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
