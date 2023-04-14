func camelMatch(queries []string, pattern string) []bool {
	pLen := len(pattern)
	answer := []bool{}
	for _,v := range queries {
		pa := 0
		va := 0
		flag := false
		for pa < pLen && va < len(v) {
			if pattern[pa] == v[va] {
				pa++
				va++
			} else if unicode.IsLower(rune(v[va])) {
				va++
			} else {
				answer = append(answer,false)
				flag = true
				break
			}
		}
		if flag {
			continue
		}
		if pa < pLen {
			answer = append(answer,false)
			continue
		}
		for va < len(v) {
			if unicode.IsUpper(rune(v[va])) {
				answer = append(answer,false)
				flag = true
				break
			}
			va++
		}
		if flag {
			continue
		}
		answer = append(answer,true)
	}
	return answer
}
