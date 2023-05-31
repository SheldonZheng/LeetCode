func mctFromLeafValues(arr []int) int {
	n := len(arr)
	dp := make([][]int,n)
	g := make([][]int,n)
	for i := range g {
		dp[i] = make([]int,n)
		g[i] = make([]int,n)
	}
	for i := n - 1;i >= 0;i-- {
		g[i][i] = arr[i]
		for j := i + 1;j < n;j++ {
			g[i][j] = max(g[i][j - 1],arr[j])
			dp[i][j] = 1 << 30
			for k := i;k < j;k++ {
				dp[i][j] = min(dp[i][j],dp[i][k] + dp[k + 1][j] + g[i][k] * g[k + 1][j])			
			}
		}
	}
	return dp[0][n - 1]
}

func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
