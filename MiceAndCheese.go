func miceAndCheese(reward1 []int, reward2 []int, k int) int {
	res := 0
	for i,v := range reward2 {
		res += v
		reward1[i] -= v
	}
	sort.Ints(reward1)
	n := len(reward1)
	for i := 0;i < k;i++ {
		res += reward1[n - i - 1]
	}
	return res
}
