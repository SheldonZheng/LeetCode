func countHomogenous(s string) int {
	const mod int = 1e9 + 7
	prev := rune(s[0])
	cnt := 0
	res := 0
	for _,v := range s {
		if v == prev {
			cnt++
		} else {
			res += (cnt + 1) * cnt / 2
			cnt = 1
			prev = v
		}
	}
	res += (cnt + 1) * cnt / 2
	return res % mod
}
