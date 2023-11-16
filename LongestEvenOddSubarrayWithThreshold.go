func longestAlternatingSubarray(nums []int, threshold int) int {
	res := 0
	for l, n := 0, len(nums); l < n; {
		if nums[l] % 2 == 0 && nums[l] <= threshold {
			r := l + 1
			for r < n && nums[r] % 2 != nums[r - 1] % 2 && nums[r] <= threshold {
				r++
			}
			res = max(res,r - l)
			l = r
		} else {
			l++
		}
	}
	return res
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
