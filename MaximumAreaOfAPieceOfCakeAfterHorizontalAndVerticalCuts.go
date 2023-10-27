func maxArea(h int, w int, horizontalCuts []int, verticalCuts []int) int {
	sort.Ints(horizontalCuts)
	sort.Ints(verticalCuts)
	return calMax(horizontalCuts, h) * calMax(verticalCuts, w) % 1000000007
}

func calMax(arr []int, boardr int) int {
	res, pre := 0, 0
	for _, i := range arr {
		res = max(i - pre, res)
		pre = i
	}
	return max(res, boardr - pre)
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
