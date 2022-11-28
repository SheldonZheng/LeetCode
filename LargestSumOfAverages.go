func largestSumOfAverages(nums []int, k int) float64 {
	if nums == nil {
		return 0
	}
	n := len(nums)
	pre := make([]float64,n + 1)
	for i,v := range nums {
		pre[i + 1] = pre[i] + float64(v)
	}
	dp := make([][]float64,n + 1)
	for i := range dp {
		dp[i] = make([]float64,k + 1)
	}
	for i := 1;i <= n;i++ {
		dp[i][1] = pre[i] / float64(i)
	}
	for j := 2;j <= k;j++ {
		for i := j;i <= n;i++ {
			for x := j - 1;x < i;x++ {
				dp[i][j] = math.Max(dp[i][j],dp[x][j - 1] + ((pre[i] - pre[x]) / float64(i - x)))
			}
		}
	}
	return dp[n][k]
}
