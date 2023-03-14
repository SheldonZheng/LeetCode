func restoreMatrix(rowSum []int, colSum []int) [][]int {
	n,m := len(rowSum),len(colSum)
	res := make([][]int,n)
	for i := range res {
		res[i] = make([]int,m)
	}
	i,j := 0,0
	for i < n && j < m {
		v := min(rowSum[i],colSum[j])
		res[i][j] = v
		rowSum[i] -= v
		colSum[j] -= v
		if rowSum[i] == 0 {
			i++
		}
		if colSum[j] == 0 {
			j++
		}
	}
	return res
}

func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}
