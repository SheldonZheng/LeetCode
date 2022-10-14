func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}

func coinChange(coins []int, amount int) int {
	if amount == 0 {
		return 0
	}
	dp := make([]int,amount + 1)
	for i := range dp {
		dp[i] = math.MaxInt32
	}
	dp[0] = 0
	for i := 1;i <= amount;i++ {
		for j := 0;j < len(coins);j++ {
			if coins[j] <= i {
				dp[i] = min(dp[i],dp[i - coins[j]] + 1)
			}
		}
	}

    if dp[amount] == math.MaxInt32 {
        return -1
    } else {
        return dp[amount]
    }
}
