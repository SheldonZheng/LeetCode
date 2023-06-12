const kLog = 16

type TreeAncestor struct {
	ancestors [][]int
}


func Constructor(n int, parent []int) TreeAncestor {
	var this TreeAncestor
	this.ancestors = make([][]int,n)
	for i := 0;i < n;i++ {
		this.ancestors[i] = make([]int,kLog)
		for j := 0;j < kLog;j++ {
			this.ancestors[i][j] = -1
		}
		this.ancestors[i][0] = parent[i]
	}
	for j := 1;j < kLog;j++ {
		for i := 0;i < n;i++ {
			if this.ancestors[i][j - 1] != -1 {
				this.ancestors[i][j] = this.ancestors[this.ancestors[i][j - 1]][j - 1]
			}
		}
	}
	return this
}


func (this *TreeAncestor) GetKthAncestor(node int, k int) int {
	for j := 0;j < kLog;j++ {
		if (k >> j) & 1 != 0 {
			node = this.ancestors[node][j]
			if node == -1 {
				return -1
			}
		}
	}
	return node
}
