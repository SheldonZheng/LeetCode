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
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        return buildTree(preorder, inorder,0,preorder.length - 1,0,inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder,int preOrderLeft, int preOrderRight, int inoOrderLeft, int intOrderRight) {
        if (preOrderLeft > preOrderRight) {
            return null;
        }
        int preOrderRoot = preOrderLeft;
        int inOrderRoot = indexMap.get(preorder[preOrderRoot]);
        TreeNode root = new TreeNode(preorder[preOrderRoot]);

        int leftSize = inOrderRoot - inoOrderLeft;
        root.left = buildTree(preorder,inorder,preOrderLeft + 1, preOrderLeft + leftSize,inoOrderLeft,inOrderRoot - 1);
        root.right = buildTree(preorder,inorder,preOrderLeft + leftSize + 1,preOrderRight, inOrderRoot + 1,intOrderRight);
        return root;
    }
}
