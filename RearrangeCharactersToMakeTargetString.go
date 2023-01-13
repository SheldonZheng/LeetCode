func rearrangeCharacters(s string, target string) int {
	var cntS [26]int
	var cntT [26]int
	for _,v := range s {
		cntS[v - 'a']++
	}
	for _,v := range target {
		cntT[v - 'a']++
	}
	res := len(s)
	for i,v := range cntT {
		if v > 0 {
			res = min(res,cntS[i] / v)
			if res == 0 {
				return res
			}
		}
	}
	return res
}

func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}
