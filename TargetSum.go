func findTargetSumWays(nums []int, target int) int {
	if nums == nil {
		return 0
	}
	sum := 0
	for _,v := range nums {
		sum += v
	}
	diff := sum - target
	if diff < 0 || diff % 2 == 1 {
		return 0
	}

	n := len(nums)
	sumTarget := diff / 2
	dp := make([][]int,n + 1)
	for i := range dp {
		dp[i] = make([]int,sumTarget + 1)
	}
	dp[0][0] = 1
	for i,v := range nums {
		for j := 0;j <= sumTarget;j++ {
			if j < v {
				dp[i + 1][j] = dp[i][j]
			} else {
				dp[i + 1][j] = dp[i][j] + dp[i][j - v]
			}
		}
	}
	return dp[n][sumTarget]
}
