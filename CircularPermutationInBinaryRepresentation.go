func circularPermutation(n int, start int) []int {
	res := make([]int,1,1 << n)
	res[0] = start
	for i := 1;i <= n;i++ {
		for j := len(res) - 1;j >= 0;j-- {
			res = append(res,  ((res[j] ^ start) | (1 << (i - 1))) ^ start)
		}
	}
	return res
}
