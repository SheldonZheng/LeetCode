func partitionLabels(s string) []int {
	var res = make([]int,0)
	if (len(s) == 0) {
		return res
	}

	lastPos := [26]int{}

	for i,c := range s {
		lastPos[c - 'a'] = i
	}

	start,end := 0,0
	for i := 0;i < len(s);i++ {
		if (lastPos[s[i] - 'a'] > end) {
			end = lastPos[s[i] - 'a']
		}
		if (i == end) {
			res = append(res,end - start + 1)
			start = end + 1
		}
	}
	return res

}
