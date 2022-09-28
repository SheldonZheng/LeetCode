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

func maximalSquare(matrix [][]byte) int {
	if matrix == nil || len(matrix) == 0 {
		return 0
	}
	maxSide := 0
	n := len(matrix)
	m := len(matrix[0])
	dp := make([][]int,n + 1)
	for i := 0;i <= n;i++ {
		dp[i] = make([]int,m + 1)
	}
	for i := 1;i <= n;i++ {
		for j := 1;j <= m;j++ {
			if matrix[i - 1][j - 1] == '1' {
				dp[i][j] = min(min(dp[i - 1][j],dp[i - 1][j - 1]),dp[i][j - 1]) + 1
			}
			maxSide = max(maxSide,dp[i][j])
		}
	}
	return maxSide * maxSide
}
