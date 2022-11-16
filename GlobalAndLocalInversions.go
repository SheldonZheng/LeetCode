func isIdealPermutation(nums []int) bool {
	if nums == nil {
		return true
	}
	n := len(nums)
	curMin := nums[n - 1]
	for i := n - 3;i >= 0;i-- {
		if nums[i] > curMin {
			return false
		}
		curMin = min(curMin,nums[i + 1])
	}
    return true
}

func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}
