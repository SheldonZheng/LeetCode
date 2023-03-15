func maximalNetworkRank(n int, roads [][]int) int {
	connect := make([][]int,n)
	for i := range connect {
		connect[i] = make([]int,n)
	}
	degree := make([]int,n)
	for _,v := range roads {
		connect[v[0]][v[1]] = 1
		connect[v[1]][v[0]] = 1
		degree[v[0]]++
		degree[v[1]]++
	}

	maxRank := 0
	for i := 0;i < n;i++ {
		for j := i + 1;j < n;j++ {
			rank := degree[i] + degree[j] - connect[i][j]
			maxRank = max(maxRank,rank)
		}
	}
	return maxRank
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
