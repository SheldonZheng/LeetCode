func minimumLength(s string) int {
	n := len(s)
	if n <= 1 {
		return n
	}
	l := 0
	r := n - 1
	curIdx := byte('d')
	removeCnt := 0
	for l < r {
		if curIdx == s[l] && curIdx == s[r] {
			removeCnt += 2
			l++
			r--
		} else if curIdx == s[l] {
			removeCnt++
			l++
		} else if curIdx == s[r] {
			removeCnt++
			r--
		} else {
			if s[l] != s[r] {
				return n - removeCnt
			} else {
				curIdx = s[l]
			}
		}
	}
	if l == r && s[l] == curIdx {
		removeCnt++
	}
	return n - removeCnt
}
