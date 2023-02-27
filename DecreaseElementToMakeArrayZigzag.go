func movesToMakeZigzag(nums []int) int {
	help := func(pos int) int {
		res := 0
		for i := pos;i < len(nums);i += 2 {
			cur := 0
			if i - 1 >= 0 {
				cur = max(cur,nums[i] - nums[i - 1] + 1)
			}
			if i + 1 < len(nums) {
				cur = max(cur,nums[i] - nums[i + 1] + 1)
			}
			res += cur
		}
		return res
	}
	return min(help(0),help(1))
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}

func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}
