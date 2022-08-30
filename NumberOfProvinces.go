func findCircleNum(isConnected [][]int) int {
	visited := make([]bool,len(isConnected))
	var dfs func(int)
	dfs = func (from int) {
		visited[from] = true
		for next,val := range isConnected[from] {
			if (val == 1 && !visited[next]) {
				dfs(next)
			}
		}
	}
	res := 0
	for i := 0;i < len(isConnected);i++ {
		if !visited[i] {
			dfs(i)
			res++
		}
	}
	return res
}
