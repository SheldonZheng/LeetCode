func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}

func numSquares(n int) int {
	if n < 2 {
		return n
	}
	dp := make([]int,n + 1)
	dp[0] = 0
	for i := 1;i <= n;i++ {
		dp[i] = math.MaxInt32
		for j := 1;j * j <= i;j++ {
			dp[i] = min(dp[i],dp[i - j * j] + 1)
		}
	}
	return dp[n]
}
