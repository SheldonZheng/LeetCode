/**
 * 剑指Offer 38 字符串的排列
 */
func permutation(s string) (ans []string) {
	if len(s) == 0 {
		return ans
	}
	t := []byte(s)
	sort.Slice(t, func (i,j int) bool { return t[i] < t[j]})
	n := len(t)
	perm := make([]byte,0,n)
	vis := make([]bool,n)
	var backtrack func(int)
	backtrack = func(i int) {
		if i == n {
			ans = append(ans,string(perm))
			return
		}
		for index,isVisited := range vis {
			if isVisited || index > 0 && !vis[index - 1] && t[index - 1] == t[index] {
				continue
			}
			vis[index] = true
			perm = append(perm,t[index])
			backtrack(i + 1)
			perm = perm[:len(perm) - 1]
			vis[index] = false
		}
	}
    backtrack(0)
	return ans
}
