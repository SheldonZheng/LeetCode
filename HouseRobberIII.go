/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rob(root *TreeNode) int {
	var dfs func(*TreeNode) (int, int)
	dfs = func(cur *TreeNode) (int, int) {
		if cur == nil {
			return 0, 0
		}
		la, lb := dfs(cur.Left)
		ra, rb := dfs(cur.Right)
		return cur.Val + lb + rb, max(la,lb) + max(ra,rb)
	}
	return max(dfs(root))
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
