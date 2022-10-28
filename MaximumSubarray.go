func maxSubArray(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	n := len(nums)
	dp := make([]int,n)
	dp[0] = nums[0]
	res := nums[0]
	for i := 1;i < n;i++ {
		dp[i] = max(dp[i - 1] + nums[i],nums[i])
		res = max(res,dp[i])
	}
	return res
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
