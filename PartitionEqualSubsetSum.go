func canPartition(nums []int) bool {
	if nums == nil || len(nums) < 2 {
		return false
	}
	n := len(nums)
	sum := 0
    max := 0
	for _,v := range nums {
		sum += v
        if v > max {
            max = v
        }
	}
	if sum % 2 != 0 {
		return false
	}
	target := sum / 2
	
    if max > target {
        return false
    }

	dp := make([][]bool,n)
	for i := range dp {
		dp[i] = make([]bool,target + 1)
		if i < n {
			dp[i][0] = true
		}
	}

	dp[0][nums[0]] = true
	for i := 1;i < n;i++ {
		for j := 1;j <= target;j++ {
			if j >= nums[i] {
				dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]
			} else {
				dp[i][j] = dp[i - 1][j]
			}
		}
	}
	return dp[n - 1][target]
}
