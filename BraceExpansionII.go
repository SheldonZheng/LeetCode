func braceExpansionII(expression string) []string {
	s := map[string]int{}
	var dfs func(string)
	dfs = func (exp string) {
		j := strings.Index(exp,"}")
		if j == -1 {
			s[exp] = 0
			return
		}
		i := strings.LastIndex(exp[:j],"{")
		a,c := exp[:i],exp[j + 1:]
		for _,b := range strings.Split(exp[i + 1:j],",") {
			dfs(a + b + c)
		}
	}
	dfs(expression)
	res := make([]string,0)
	for k := range s {
		res = append(res,k)
	}
	sort.Strings(res)
	return res
}
