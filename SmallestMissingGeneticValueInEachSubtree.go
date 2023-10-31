func smallestMissingValueSubtree(parents []int, nums []int) []int {
	n := len(parents)
	res := make([]int, n)
	for i := range res {
		res[i] = 1
	}
	node := slices.Index(nums, 1)
	if node < 0 {
		return res
	}
	g := make([][]int, n)
	for i := 1;i < n;i++ {
		p := parents[i]
		g[p] = append(g[p], i)
	}

	vis := make(map[int]bool, n)
	var dfs func(int)
	dfs = func(x int) {
		vis[nums[x]] = true
		for _, son := range g[x] {
			if !vis[nums[son]] {
				dfs(son)
			}
		}
	}

	for mex := 2;node >= 0;node = parents[node] {
		dfs(node)
		for vis[mex] {
			mex++
		}
		res[node] = mex
	}
	return res
}
