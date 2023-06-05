func applyOperations(nums []int) []int {
	n := len(nums)
	for i := 0;i < n - 1;i++ {
		if nums[i] == nums[i + 1] {
			nums[i] <<= 1
			nums[i + 1] = 0
		}
	}
	res := make([]int,n)
	i := 0
	for _,x := range nums {
		if x > 0 {
			res[i] = x
			i++
		}
	}
	return res
}
