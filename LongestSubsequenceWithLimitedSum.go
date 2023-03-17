func answerQueries(nums []int, queries []int) []int {
	sort.Ints(nums)
	n := len(nums)
	preSum := make([]int,n)
	preSum[0] = nums[0]
	for i := 1;i < n;i++ {
		preSum[i] = preSum[i - 1] + nums[i]
	}
	res := []int{}
	for _,q := range queries {
		idx := sort.SearchInts(preSum,q + 1)
		res = append(res,idx)
	}
	return res
}
