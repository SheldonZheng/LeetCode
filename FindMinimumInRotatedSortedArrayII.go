func findMin(nums []int) int {
	n := len(nums)
	l := 0
	r := n - 1
	for (l <= r) {
		mid := (l + r) / 2
		if (nums[mid] < nums[r]) {
			r = mid
		} else if (nums[mid] > nums[r]) {
			l = mid + 1
		} else {
			r--
		}
	}
	return nums[l]
}
