func numMatchingSubseq(s string, words []string) int {
	if words == nil {
		return 0
	}
	type pair struct { i,j int}
	container := [26][]pair{}
	for i,v := range words {
		container[v[0] - 'a'] = append(container[v[0] - 'a'],pair{i,0})
	}
	res := 0
	for _,c := range s {
		q := container[c - 'a']
		container[c - 'a'] = nil
		for _,p := range q {
			p.j++
			if p.j == len(words[p.i]) {
				res++
			} else {
				w := words[p.i][p.j] - 'a'
				container[w] = append(container[w],p)
			}
		}
	}
	return res
}
