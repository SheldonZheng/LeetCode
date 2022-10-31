func integerBreak(n int) int {
	if n < 2 {
		return 0
	}
	dp := make([]int,n + 1)
	dp[0] = 0
	dp[1] = 0
	for i := 2;i <= n;i++ {
		curMax := 0
		for j := 1;j < i;j++ {
			curMax = max(curMax,max(j * (i - j),j * dp[i - j]))
		}
		dp[i] = curMax
	}
	return dp[n]
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
