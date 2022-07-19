func findContentChildren(g []int, s []int) int {
	if (g == nil || len(g) == 0 || s == nil || len(s) == 0) {
		return 0
	}
	sort.Ints(g)
	sort.Ints(s)
	child := 0
	cookie := 0
	for (child < len(g) && cookie < len(s)) {
		if (g[child] <= s[cookie]) {
			child++
		}
		cookie++
	}
	return child
}
