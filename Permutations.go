func permute(nums []int) [][]int {
	res := make([][]int,0)
	if (nums == nil || len(nums) == 0) {
		return res
	}

	var backtrack func ([] int,int)

	backtrack = func(nums[] int,curIdx int) {
		if (curIdx == len(nums) - 1) {
			var temp = make([]int,len(nums))
			copy(temp,nums)
			res = append(res,temp)
			return
		}

		for i := curIdx;i < len(nums);i++ {
			nums[i],nums[curIdx] = nums[curIdx],nums[i]
			backtrack(nums,curIdx + 1)
			nums[i],nums[curIdx] = nums[curIdx],nums[i]
		}
	}

	backtrack(nums,0)
	return res
}


