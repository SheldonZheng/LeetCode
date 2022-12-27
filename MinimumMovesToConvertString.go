func minimumMoves(s string) int {
	idx := -1
	res := 0
	for i,v := range s {
		if v == 'X' && i > idx {
			res++
			idx = i + 2
		}
	}
	return res
}
