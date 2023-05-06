func minNumberOfFrogs(croakOfFrogs string) int {
	if len(croakOfFrogs) % 5 != 0 {
		return -1
	}
	res := 0
	frogNum := 0
	cnt := make([]int,4)
	mp := map[rune]int{'c': 0, 'r': 1, 'o': 2, 'a': 3, 'k': 4}
	for _,c := range croakOfFrogs {
		t := mp[c]
		if c == 'c' {
			cnt[t]++
			frogNum++
			if frogNum > res {
				res = frogNum
			}
		} else {
			if cnt[t - 1] == 0 {
				return -1
			}
			cnt[t - 1]--
			if t == 4 {
				frogNum--
			} else {
				cnt[t]++
			}
		}
	}
	if frogNum > 0 {
		return -1
	}
	return res
}
