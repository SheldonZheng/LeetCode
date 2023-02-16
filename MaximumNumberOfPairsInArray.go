func numberOfPairs(nums []int) []int {
	cnt := map[int]bool{}
	res := 0
	for _,num := range nums {
		cnt[num] = !cnt[num]
		if !cnt[num] {
			res++
		}
	}
	return []int{res,len(nums) - 2 * res}
}
