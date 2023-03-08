func maxValue(grid [][]int) int {
	m,n := len(grid),len(grid[0])
	dp := make([][]int,m)
	for i := range dp {
		dp[i] = make([]int,n)
	}
	for i,g := range grid {
		for j,v := range g {
			if i > 0 {
				dp[i][j] = max(dp[i][j],dp[i - 1][j])
			}
			if j > 0 {
				dp[i][j] = max(dp[i][j],dp[i][j - 1])
			}
			dp[i][j] += v
		}
	}
	return dp[m - 1][n - 1]
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
