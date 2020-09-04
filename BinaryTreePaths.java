/**
     * LeetCode 257 Binary Tree Paths
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList();
            if (root == null) {
                return res;
            }
            dfs(root, res, new String());
            return res;
        }

        public void dfs(TreeNode root, List<String> res, String cur) {
            if (cur == null) {
                cur = new String();
            }
            if (root.left == null && root.right == null) {
                res.add(cur.concat(String.valueOf(root.val)));
                return;
            } else {
                cur = cur.concat(String.valueOf(root.val)).concat("->");
                if (root.left != null) {
                    dfs(root.left, res, cur);
                }
                if (root.right != null) {
                    dfs(root.right, res, cur);
                }
                return;
            }
        }
    }
