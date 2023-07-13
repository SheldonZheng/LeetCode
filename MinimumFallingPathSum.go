func minFallingPathSum(matrix [][]int) int {
	n := len(matrix)
	dp := make([][]int,n)
	for i := range dp {
		dp[i] = make([]int,n)
	}
	copy(dp[0],matrix[0])
	for i := 1;i < n;i++ {
		for j := 0;j < n;j++ {
			mn := dp[i - 1][j]
			if j > 0 {
				mn = min(mn,dp[i - 1][j - 1])
			}
			if j < n - 1 {
				mn = min(mn,dp[i - 1][j + 1])
			}
			dp[i][j] = mn + matrix[i][j]
		}
	}

	minVal := dp[n - 1][0]
	for _,val := range dp[n - 1] {
		if val < minVal {
			minVal = val
		}
	}
	return minVal
}

func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}
