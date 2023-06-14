func numTimesAllBlue(flips []int) int {
	res := 0
	curMax := 0
	for i := 0;i < len(flips);i++ {
		if curMax < flips[i] {
			curMax = flips[i]
		}
		if i + 1 == curMax {
			res++
		}
	}
	return res
}
