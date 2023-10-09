func splitNum(num int) int {
	cnt := [10]int{}
	n := 0
	for ; num > 0; num /= 10 {
		cnt[num % 10]++
		n++
	}
	res := [2]int{}
	for i, j := 0, 0; i < n;i++ {
		for cnt[j] == 0 {
			j++
		}
		cnt[j]--
		res[i & 1] = res[i & 1] * 10 + j
	}
	return res[0] + res[1]
}
