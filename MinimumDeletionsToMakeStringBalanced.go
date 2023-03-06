func minimumDeletions(s string) int {
	leftb := 0
	righta := 0
	for _,c := range s {
		if c == 'a' {
			righta++
		}
	}
	res := righta
	for _,c := range s {
		if c == 'a' {
			righta--
		} else {
			leftb++
		}
		res = min(res,leftb + righta)
	}
	return res
}

func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}
