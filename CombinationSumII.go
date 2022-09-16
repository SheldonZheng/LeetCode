func combinationSum2(candidates []int, target int) [][]int {
	sort.Ints(candidates)
	res := make([][]int,0)
	n := len(candidates)
	vis := make([]bool,n)
	var backtrack func(int,int,[]int)
	backtrack = func(sum int,idx int,curPath []int) {
		if sum > target {
			return
		}
		if sum == target {
			res = append(res,append([]int(nil),curPath...))
		}
		for i := idx;i < n;i++ {
			if vis[i] || i > 0 && !vis[i - 1] && candidates[i] == candidates[i - 1] {
				continue
			}
			curPath = append(curPath,candidates[i])
			vis[i] = true
			backtrack(sum + candidates[i],i + 1,curPath)
			vis[i] = false
			curPath = curPath[0:len(curPath) - 1]
		}
	}
	backtrack(0,0,[]int{})
	return res
}
