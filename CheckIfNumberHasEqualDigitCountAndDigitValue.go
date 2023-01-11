func digitCount(num string) bool {
	cnt := map[rune]int{}
	for _,v := range num {
		cnt[v - '0']++
	}
	for i,v := range num {
		if cnt[rune(i)] != int(v - '0') {
			return false
		}
	}
	return true
}
