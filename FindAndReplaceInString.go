func findReplaceString(s string, indices []int, sources []string, targets []string) string {
	n := len(s)
	d := make([]int,n)

	for k, i := range indices {
		if strings.HasPrefix(s[i:],sources[k]) {
			d[i] = k + 1
		}
	}

	res := &strings.Builder{}
	for i := 0;i < n; {
		if d[i] > 0 {
			res.WriteString(targets[d[i] - 1])
			i += len(sources[d[i] - 1])
		} else {
			res.WriteByte(s[i])
			i++
		}
	}
	return res.String()
}
