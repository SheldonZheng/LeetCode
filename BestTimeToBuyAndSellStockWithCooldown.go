func maxProfit(prices []int) int {
	if prices == nil || len(prices) < 2 {
		return 0
	}
	n := len(prices)
	dp := make([][]int,n)
	for i := range dp {
		dp[i] = make([]int,3)
	}
	dp[0][0] = -prices[0]
	dp[0][1] = 0
	dp[0][2] = 0

	for i := 1;i < n;i++ {
		dp[i][0] = max(dp[i - 1][0],dp[i - 1][2] - prices[i])
		dp[i][1] = dp[i - 1][0] + prices[i]
		dp[i][2] = max(dp[i - 1][1],dp[i - 1][2])
	}
	return max(dp[n - 1][1],dp[n - 1][2])
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
