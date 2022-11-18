func sumSubseqWidths(nums []int) int {
	if nums == nil {
		return 0
	}
	var mod int = 1e9 + 7
	sort.Ints(nums)
	n := len(nums)
	pow := make([]int,n)
	pow[0] = 1
	for i := 1;i < n;i++ {
		pow[i] = pow[i - 1] * 2 % mod
	}
	var res int = 0
	for i,v := range nums {
		res += (pow[i] - pow[n - 1 - i]) * v
	}
	return (res % mod + mod) % mod
}
