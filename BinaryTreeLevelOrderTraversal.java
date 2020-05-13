/**
 * LeetCode 102 Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> container = new LinkedList<>();
        container.offer(root);
        while (!container.isEmpty()) {
            int curSize = container.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode poll = container.poll();
                if (poll.left != null) {
                    container.offer(poll.left);
                }
                if (poll.right != null) {
                    container.offer(poll.right);
                }
                curLevel.add(poll.val);
            }
            result.add(curLevel);
        }
        return result;
    }
}
