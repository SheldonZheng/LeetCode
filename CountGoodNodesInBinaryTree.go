/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func goodNodes(root *TreeNode) int {
	max := root.Val
	return dfs(max,root)
}

func dfs(max int,root *TreeNode) int {
	if root == nil {
		return 0
	}
	cur := 0
	if root.Val >= max {
		cur++
		max = root.Val
	}
	return cur + dfs(max,root.Left) + dfs(max,root.Right)
}
