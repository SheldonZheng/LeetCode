func permuteUnique(nums []int) [][]int {
    sort.Ints(nums)
	res := make([][]int,0)
	n := len(nums)
	vis := make([]bool,n)
	cur := []int{}
	var backtrack func(int)
	backtrack = func(idx int) {
		if idx == n {
			res = append(res,append([]int(nil),cur...))
		}
		for i,v := range nums {
			if vis[i] || i > 0 && !vis[i - 1] && v == nums[i - 1] {
				continue
			}
			cur = append(cur,v)
			vis[i] = true
			backtrack(idx + 1)
			vis[i] = false
			cur = cur[0:len(cur) - 1]
		}
	}
	backtrack(0)
	return res
}
