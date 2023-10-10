func sumDistance(nums []int, s string, d int) int {
	for i, c := range s {
		if c == 'R' {
			nums[i] += d
		} else {
			nums[i] -= d
		}
	}
	sort.Ints(nums)
	sum := 0
	const mod int = 1e9 + 7
	res := 0
	for i, x := range nums {
		res = (res + (i * x - sum)) % mod
		sum += x
	}
	return res
}
