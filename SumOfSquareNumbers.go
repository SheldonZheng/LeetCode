func judgeSquareSum(c int) bool {
	l,r := 0,int(math.Sqrt(float64(c)))
	for l <= r {
		cur := l * l + r * r
		if (cur == c) {
			return true
		} else if (cur > c) {
			r--
		} else {
			l++
		}
	}
	return false
}
