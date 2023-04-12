func longestDecomposition(text string) int {
	if len(text) == 1 {
		return 1
	}
	k := 0
	str := text
	for len(str) > 0 {
		l := 1
		r := len(str) - 1
		for l <= r {
			if str[:l] == str[r:] {
				k += 2
				str = str[l:r]
				break
			}
			l++
			r--
		}
		if l > r && len(str) > 0 {
			k++
			break
		}
	}
	return k
}
