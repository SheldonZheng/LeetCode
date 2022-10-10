func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}

func lengthOfLIS(nums []int) int {
	n := len(nums)
	dp := make([]int,n)
	maxRes := 0
	for i := 0;i < n;i++ {
		dp[i] = 1
	}
	
	for i := 0;i < n;i++ {
		for j := 0;j < i;j++ {
			if (nums[j] < nums[i]) {
				dp[i] = max(dp[i],dp[j] + 1)
			}
		}
		maxRes = max(maxRes,dp[i])
	}
	return maxRes
}
