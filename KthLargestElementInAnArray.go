func findKthLargest(nums []int, k int) int {
	l := 0
	r := len(nums) - 1
	target := len(nums) - k
	for (l < r) {
		mid := quickSelection(nums,l,r)
		if (mid == target) {
			return nums[mid]
		}
		if (mid < target) {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return nums[l]
}

func quickSelection(nums[] int,l int,r int) int {
	i := l + 1
	j := r
	for {
		for (i < r && nums[i] <= nums[l]) {
			i++
		}
		for (l < j && nums[j] >= nums[l]) {
			j--
		}
		if (i >= j) {
			break
		}
		nums[i],nums[j] = nums[j],nums[i]
	}
	nums[l],nums[j] = nums[j],nums[l]
	return j
}

