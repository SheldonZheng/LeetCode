func smallestRepunitDivByK(k int) int {
	if k % 2 == 0 || k % 5 == 0 {
		return -1
	}
	n := 1 % k
	for i := 1;i <= k;i++ {
		if n == 0 {
			return i
		}
		n = (n * 10 + 1) % k
	}
	return -1
}
