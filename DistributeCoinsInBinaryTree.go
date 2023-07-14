/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var move int

func distributeCoins(root *TreeNode) int {
	move = 0
	dfs(root)
	return move
}

func dfs(root *TreeNode) int {
	moveLeft := 0
	moveRight := 0
	if root == nil {
		return 0
	}

	if root.Left != nil {
		moveLeft = dfs(root.Left)
	}
	if root.Right != nil {
		moveRight = dfs(root.Right)
	}
	move += abs(moveLeft) + abs(moveRight)
	return moveLeft + moveRight + root.Val - 1
}

func abs(v int) int {
	if v < 0 {
		return -v
	}
	return v
}
