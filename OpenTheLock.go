/**
 * LeetCode 752 Open the Lock
 */
func openLock(deadends []string, target string) int {
	if deadends == nil {
		panic("param error")
	}
	const start = "0000"
	if target == start {
		return 0
	}

	dead := map[string]bool{}
	for _,s := range deadends {
		dead[s] = true
	}
	if dead[start] {
		return -1
	}

	get := func(status string) (ret []string) {
		s := []byte(status)
		for i,b := range s {
			s[i] = b - 1
			if s[i] < '0' {
				s[i] = '9'
			}
			ret = append(ret,string(s))
			s[i] = b + 1
			if s[i] > '9' {
				s[i] = '0'
			}
			ret = append(ret,string(s))
			s[i] = b
		}
		return ret
	}

	type pair struct {
		status string
		step int
	}

	q := []pair{{start,0}}
	seen := map[string]bool{start: true}
	for len(q) > 0 {
		p := q[0]
		q = q[1:]
		for _,nxt := range get(p.status) {
			if !seen[nxt] && !dead[nxt] {
				if nxt == target {
					return p.step + 1
				}
				seen[nxt] = true
				q = append(q,pair{nxt,p.step + 1})
			}
		}
	}
	return -1
} 
