/**
 * LeetCode 872 Leaf-Similar Trees
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		List<Integer> container1 = new ArrayList<>();
		List<Integer> container2 = new ArrayList<>();
		dfs(container1,root1);
		dfs(container2,root2);

		return container1.equals(container2);
	}

	private void dfs(List<Integer> container, TreeNode root) {
		if (root != null && root.left == null && root.right == null) {
			container.add(root.val);
		}
		if (root.left != null) {
			dfs(container,root.left);
		}
		if (root.right != null) {
			dfs(container,root.right);
		}
	}
}
