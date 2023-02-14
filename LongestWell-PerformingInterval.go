func longestWPI(hours []int) int {
	res := 0
	s := 0
	pos := map[int]int{}
	for l,v := range hours {
		if v > 8 {
			s++
		} else {
			s--
		}
		if s > 0 {
			res = l + 1
		} else if i,ok := pos[s - 1]; ok {
			res = max(res,l - i)
		}
		if _,ok := pos[s]; !ok {
			pos[s] = l
		}
	}
	return res
}


func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
