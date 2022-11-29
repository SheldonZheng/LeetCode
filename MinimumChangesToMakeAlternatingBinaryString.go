func minOperations(s string) int {
	if len(s) < 1 {
		return 0
	}
	res := 0
	for i,v := range s {
		if i % 2 != int(v - '0') {
			res++
		}
	}
	return min(res,len(s) - res)
}

func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}
