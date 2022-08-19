func singleNonDuplicate(nums []int) int {
	l , r := 0, len(nums) - 1
	for (l < r) {
		mid := (l + r) / 2
		mid -= mid & 1
		if (nums[mid] == nums[mid + 1]) {
			l = mid + 2
		} else {
			r = mid
		}
	}
	return nums[l]
}
