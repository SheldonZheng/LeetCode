func evaluate(s string, knowledge [][]string) string {
	dict := map[string]string{}
	for _,v := range knowledge {
		dict[v[0]] = v[1]
	}
	res := &strings.Builder{}
	start := -1
	for i,c := range s {
		if c == '(' {
			start = i
		} else if c == ')' {
			if t,ok := dict[s[start + 1:i]]; ok {
				res.WriteString(t)
			} else {
				res.WriteByte('?')
			}
			start = -1
		} else if start < 0 {
			res.WriteRune(c)
		}
	}
	return res.String()
}
