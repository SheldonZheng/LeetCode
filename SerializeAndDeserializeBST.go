/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type Codec struct {
    
}

func Constructor() Codec {
    return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
    arr := []string{}
	var postOrder func(*TreeNode)
	postOrder = func(node *TreeNode) {
		if node == nil {
			return
		}
		postOrder(node.Left)
		postOrder(node.Right)
		arr = append(arr,strconv.Itoa(node.Val))
	}
	postOrder(root)
	return strings.Join(arr," ")
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {    
	if data == "" {
		return nil
	}
	arr := strings.Split(data," ")
	var construct func(int, int) *TreeNode
	construct = func(lower, upper int) *TreeNode {
		if len(arr) == 0 {
			return nil
		}
		val, _ := strconv.Atoi(arr[len(arr) - 1])
		if val < lower || val > upper {
			return nil
		}
		arr = arr[:len(arr) - 1]
		return &TreeNode{Val : val, Right: construct(val, upper), Left: construct(lower, val)}
	}
	return construct(math.MinInt32, math.MaxInt32)
}


/**
 * Your Codec object will be instantiated and called as such:
 * ser := Constructor()
 * deser := Constructor()
 * tree := ser.serialize(root)
 * ans := deser.deserialize(tree)
 * return ans
 */
