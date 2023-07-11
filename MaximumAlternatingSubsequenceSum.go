func maxAlternatingSum(nums []int) int64 {
	even,odd := nums[0],0
	for i := 1;i < len(nums);i++ {
		even = max(even, odd + nums[i])
		odd = max(odd,even - nums[i])
	}
	return int64(even)
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
