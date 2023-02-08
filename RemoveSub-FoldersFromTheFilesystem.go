func removeSubfolders(folder []string) []string {
	sort.Strings(folder)
	res := []string{}
	res = append(res,folder[0])
	for _,v := range folder[1:] {
		last := res[len(res) - 1]
		if !strings.HasPrefix(v,last) || v[len(last)] != '/' {
			res = append(res,v)
		}
	}
	return res
}
