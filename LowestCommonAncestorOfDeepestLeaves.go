/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func lcaDeepestLeaves(root *TreeNode) *TreeNode {
	_, lca := dfs(root)
	return lca
}

func dfs(root *TreeNode) (int, *TreeNode) {
	if root == nil {
		return 0, nil
	}

	d1,lca1 := dfs(root.Left)
	d2,lca2 := dfs(root.Right)
	if d1 > d2 {
		return d1 + 1,lca1
	}
	if d2 > d1 {
		return d2 + 1,lca2
	}
	return d1 + 1,root
}
