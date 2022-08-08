func minWindow(s string, t string) string {
	ori, cnt := map[byte]int{}, map[byte]int{}
	for i := 0;i < len(t);i++ {
        ori[t[i]]++
    }

	sLen := len(s)
	len := math.MaxInt32
	resL,resR := -1,-1

	checkStr := func() bool {
		for k,v := range ori {
			if cnt[k] < v {
				return false
			}
		}
		return true
	}

	for l,r := 0, 0; r < sLen; r++ {
		if (r < sLen && ori[s[r]] > 0) {
			cnt[s[r]]++
		}

		for (checkStr() && l <= r) {
			if (r - l + 1 < len) {
				len = r - l + 1
				resL,resR = l, r + 1
			}
			cnt[s[l]] -= 1
			l++
		}
	}
	if (resL == -1) {
		return ""
	}
	return s[resL:resR]
}
