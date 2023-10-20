func tupleSameProduct(nums []int) int {
	cnt := map[int]int{}
	for i := 1;i < len(nums);i++ {
		for j := 0;j < i;j++ {
			x := nums[i] * nums[j]
			cnt[x]++
		}
	}

	res := 0
	for _, v := range cnt {
		res += v * (v - 1) * 4
	}
	
	return res
}
