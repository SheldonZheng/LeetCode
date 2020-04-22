/**
 * LeetCode 199 Binary Tree Right Side View
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res,root,0);
        return res;
    }

    private void dfs(List<Integer> res,TreeNode root,int level) {
        if (root == null) {
            return ;
        }
        if (res.size() == level) {
            res.add(root.val);
        }
        dfs(res,root.right,level + 1);
        dfs(res,root.left,level + 1);
        return ;
    }
}
