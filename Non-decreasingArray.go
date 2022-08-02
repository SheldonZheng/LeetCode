func checkPossibility(nums []int) bool {
	if (nums == nil || len(nums) == 0) {
		return false
	}
	count := 1
	for i := 0;i < len(nums) - 1;i++ {
		if (nums[i] > nums[i + 1]) {
			if (count < 0) {
				return false
			}
			count--
			if (i > 0 && nums[i + 1] < nums[i - 1]) {
				nums[i + 1] = nums[i]
			}
		}
		
	}
	return count >= 0
}
