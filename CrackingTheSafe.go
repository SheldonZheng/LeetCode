func crackSafe(n int, k int) string {
	seen := map[int]bool{}
	res := ""
	high := int(math.Pow(10,float64(n - 1)))
	

	var dfs func(int)
	dfs = func(cur int) {
		for x := 0;x < k;x++ {
			next := cur * 10 + x
			if !seen[next] {
				seen[next] = true
				dfs(next % high)
				res += strconv.Itoa(x)
			}
		}
	}
	dfs(0)
    for i := 1;i < n;i++ {
		res += "0"
	}
	return res
}
