func maximumScore(a int, b int, c int) int {
	sum := a + b + c
	max := max(max(a,b),c)
	if sum < max * 2 {
		return sum - max
	} else {
		return sum / 2
	}
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
