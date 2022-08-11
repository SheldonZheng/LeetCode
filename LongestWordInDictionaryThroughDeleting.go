func findLongestWord(s string, dictionary []string) string {
	res := ""
	for _, t := range dictionary {
		i := 0
		for j := range s {
			if (s[j] == t[i]) {
				i++
				if (i == len(t)) {
					if (len(t) > len(res) || (len(t) == len(res) && t < res)) {
						res = t
					}
					break
				}
			}
		}
	}
	return res
}
