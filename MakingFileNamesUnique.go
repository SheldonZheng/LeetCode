func getFolderNames(names []string) []string {
	res := make([]string,len(names))
	idx := map[string]int{}
	for p,name := range names {
		i := idx[name]
		if i == 0 {
			idx[name] = 1
			res[p] = name
			continue
		}
		for idx[name + "(" + strconv.Itoa(i) + ")"] > 0 {
			i++
		}
		t := name + "(" + strconv.Itoa(i) + ")"
		res[p] = t
		idx[name] = i + 1
		idx[t] = 1
	}
	return res
}
