func numberOfArithmeticSlices(nums []int) int {
	if nums == nil || len(nums) < 3 {
		return 0
	}
	n := len(nums)
	dp := make([]int,n)
	for i := 2;i < n;i++ {
		if (nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2]) {
			dp[i] = dp[i - 1] + 1
		}
	}
	res := 0
	for _,v := range dp {
		res += v
	}
	return res
}
