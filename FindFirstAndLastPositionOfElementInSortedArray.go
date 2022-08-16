func searchRange(nums []int, target int) []int {
	left := binarySearch(nums,target,true)
	last := binarySearch(nums,target,false) - 1
	if (left <= last && last < len(nums) && nums[left] == target && nums[last] == target) {
		return []int{left,last}
	}
	return []int{-1,-1}
}

func binarySearch(nums []int, target int,flag bool) int {
	l := 0
	r := len(nums) - 1
	res := len(nums)

	for (l <= r) {
		mid := (l + r) / 2
		if (nums[mid] > target || (flag && nums[mid] >= target)) {
			r = mid - 1
			res = mid
		} else {
			l = mid + 1
		}
	}
	return res
}
