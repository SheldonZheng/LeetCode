/**
 * LeetCode 103 Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int flag = -1;
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.peek() != null)
        {
            flag = 0 - flag;
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i < size;i++)
            {
                TreeNode p = queue.poll();
                list.add(p.val);
                if(p.left != null)
                    queue.add(p.left);
                if(p.right != null)
                    queue.add(p.right);
            }
            if(flag == -1)
                Collections.reverse(list);
            result.add(list);
        }
        return result;
    }
}
