//LeetCode 515
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int floorSize = 1;
        while (floorSize > 0) {
            int tr = Integer.MIN_VALUE;
            for (int i = 0; i < floorSize; i++) {
                TreeNode t = queue.poll();
                tr = Math.max(tr,t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            result.add(tr);
            floorSize = queue.size();
        }
        return result;
    }
}
