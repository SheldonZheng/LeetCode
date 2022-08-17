func search(nums []int, target int) bool {
	n := len(nums)
	l := 0
	r := n - 1
	for (l <= r) {
		mid := (l + r) / 2
		if (nums[mid] == target) {
			return true
		}
		if (nums[l] == nums[mid]) {
			l++
		} else if (nums[mid] <= nums[r]) {
			if (target > nums[mid] && target <= nums[r]) {
				l = mid + 1
			} else {
				r = mid - 1
			}
		} else {
			if (target >= nums[l] && target < nums[mid]) {
				r = mid - 1
			} else {
				l = mid + 1
			}
		}
	}
	return false
}
