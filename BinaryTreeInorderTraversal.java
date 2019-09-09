/**
 * LeetCode 94 Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> container = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !container.isEmpty()) {
            while (cur != null) {
                container.push(cur);
                cur = cur.left;
            }
            cur = container.pop();
            resultList.add(cur.val);
            cur = cur.right;
        }
        return resultList;
    }
}
