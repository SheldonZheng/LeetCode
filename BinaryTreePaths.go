/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func binaryTreePaths(root *TreeNode) []string {
	res := make([]string,0)
	
	var backtrack func([]string,*TreeNode)
	backtrack = func(path []string,cur *TreeNode) {
		path = append(path,strconv.Itoa(cur.Val))
		if cur.Left == nil && cur.Right == nil {
			res = append(res,strings.Join(path[:],"->"))
			return 
		}
		curLen := len(path)
		if cur.Left != nil {
			backtrack(path,cur.Left)
			path = path[0:curLen]
		}
		if cur.Right != nil {
			backtrack(path,cur.Right)
			path = path[0:curLen]
		}
	}
	backtrack(make([]string,0),root)
	return res
}
