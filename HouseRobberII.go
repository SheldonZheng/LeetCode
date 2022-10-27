func rob(nums []int) int {
	if nums == nil {
		return 0
	}
	n := len(nums)
	if n == 1 {
		return nums[0]
	}
	if n == 2 {
		return max(nums[0],nums[1])
	}
	toRob := func(curs []int) int {
		dp := make([]int,len(curs))
		dp[0],dp[1] = curs[0],max(curs[0],curs[1])
		for i := 2;i < len(curs);i++ {
			dp[i] = max(dp[i - 2] + curs[i],dp[i - 1])
		}
		return dp[len(curs) - 1]
	}
	return max(toRob(nums[:n - 1]),toRob(nums[1:]))
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
