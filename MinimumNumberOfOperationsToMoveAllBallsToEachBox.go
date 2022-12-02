func minOperations(boxes string) []int {
	l := int(boxes[0] - '0')
	r := 0
	op := 0
	n := len(boxes)
	for i := 1;i < n;i++ {
		if boxes[i] == '1' {
			r++
			op += i
		}
	}
	res := make([]int,n)
	res[0] = op
	for i := 1;i < n;i++ {
		op += l - r
		if boxes[i] == '1' {
			l++
			r--
		}
		res[i] = op
	}
	return res
}
