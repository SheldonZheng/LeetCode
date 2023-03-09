func minimumRecolors(blocks string, k int) int {
	res := k
	l := 0
	whites := 0
	for r := 0;r < len(blocks);r++ {
		if blocks[r] == 'W' {
			whites++
		}
		if r < k - 1 {
			continue
		}
		res = min(res,whites)
		if blocks[l] == 'W' {
			whites--
		}
		l++
	}
	return res
}

func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}
