/**
 * LeetCode 95 Unique Binary Search Trees II
 */
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
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int left ,int right) {
        List<TreeNode> trees = new ArrayList<>();
        if (left > right) {
            trees.add(null);
            return trees;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = generateTrees(left,i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1,right);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftTree;
                    treeNode.right = rightTree;
                    trees.add(treeNode);
                }
            }
        }
        return trees;
    }
}
