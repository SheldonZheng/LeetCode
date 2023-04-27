func longestStrChain(words []string) int {
	cnt := map[string]int{}
	sort.Slice(words,func(i,j int) bool { return len(words[i]) < len(words[j])})
	res := 0
	for _,v := range words {
		cnt[v] = 1
		for i := range v {
			prev := v[:i] + v[i + 1:]
			if j := cnt[prev] + 1;j > cnt[v] {
				cnt[v] = j
			}
		}
		if cnt[v] > res {
			res = cnt[v]
		}
	}
	return res
}
