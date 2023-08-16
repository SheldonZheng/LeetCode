func circularGameLosers(n int, k int) []int {
	vis := make([]bool,n)
	for i, p := 0, 1; !vis[i];p++ {
		vis[i] = true
		i = (i + p * k) % n
	}
	res := make([]int,0)
	for i, x := range vis {
		if !x {
			res = append(res,i + 1)
		}
	}
	return res
}
