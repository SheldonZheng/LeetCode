/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return res;
        }
        Set<Integer> toDelete = new HashSet<>();
        for (int i : to_delete) {
            toDelete.add(i);
        }

        dfs(root,true,toDelete);

        return res;
    }

    public TreeNode dfs(TreeNode root,boolean isRoot,Set<Integer> toDelete) {
        if (root == null) {
            return null;
        }
        boolean deleted = toDelete.contains(root.val);
        root.left = dfs(root.left,deleted,toDelete);
        root.right = dfs(root.right,deleted,toDelete);

        if (deleted) {
            return null;
        } else {
            if (isRoot) {
                res.add(root);
            }
        }

        return root;
    }
}
