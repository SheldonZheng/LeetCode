/**
 * LeetCode 105 Construct Binary Tree from Preorder and Inorder Traversal
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
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer,Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueToIndex.put(inorder[i],i);
        }
        return helper(valueToIndex,preorder,inorder,0,inorder.length);
    }

    private TreeNode helper(Map<Integer,Integer> valueToIndex, int[] preorder, int[] inorder, int start, int end ) {
        if (start == end) {
            return null;
        }
        int rootVal = preorder[preorderIndex];
        int rootIndex = valueToIndex.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        preorderIndex++;
        root.left = helper(valueToIndex, preorder, inorder, start , rootIndex);
        root.right = helper(valueToIndex, preorder, inorder, rootIndex + 1, end);
        return root;
    }
}
