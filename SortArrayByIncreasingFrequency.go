func frequencySort(nums []int) []int {
	cnt := map[int]int{}
	for _,v := range nums {
		cnt[v]++
	}
	sort.Slice(nums,func(i,j int) bool {
		x,y := nums[i],nums[j]
		return cnt[x] < cnt[y] || cnt[x] == cnt[y] && x > y
	})
	return nums
}
