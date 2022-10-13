func findMaxForm(strs []string, m int, n int) int {
	if strs == nil || len(strs) == 0 {
		return 0
	}
	strLens := len(strs)
	dp := make([][][]int,strLens + 1)
	for i := range dp {
		dp[i] = make([][]int,m + 1)
		for j := range dp[i] {
			dp[i][j] = make([]int,n + 1)
		}
	}
	
	for i,s := range strs {
		zeros := strings.Count(s,"0")
		ones := len(s) - zeros
		for j := 0;j <= m;j++ {
			for k := 0;k <= n;k++ {
				if j < zeros || k < ones {
					dp[i + 1][j][k] = dp[i][j][k]
				} else {
					dp[i + 1][j][k] = max(dp[i][j][k],dp[i][j - zeros][k - ones] + 1)
				}
			}
		}
	}
	return dp[strLens][m][n]
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
