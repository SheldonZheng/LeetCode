/**
 * LeetCode 863 All Nodes Distance K in Binary Tree
 */
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func distanceK(root, target* TreeNode,k int) (ans []int) {
	parents := map[int]*TreeNode{}
	var findParents func(*TreeNode)
	findParents = func(node *TreeNode) {
		if node.Left != nil {
			parents[node.Left.Val] = node
			findParents(node.Left)
		}
		if node.Right != nil {
			parents[node.Right.Val] = node
			findParents(node.Right)
		}
	}
	//build Map
	findParents(root)
	var findRes func(*TreeNode,*TreeNode,int)
	findRes = func(node, from *TreeNode,depth int) {
		if node == nil {
			return
		}
		if depth == k {
			ans = append(ans,node.Val)
			return
		}
		if node.Left != from {
			findRes(node.Left,node,depth + 1)
		}
		if node.Right != from {
			findRes(node.Right,node,depth + 1)
		}
		if parents[node.Val] != from {
			findRes(parents[node.Val],node,depth + 1)
		}
	}
	findRes(target,nil,0)
	return ans
}
