func splitArraySameAverage(nums []int) bool {
	n := len(nums)
	if n < 2 {
		return false
	}
	sum := 0
	for _,v := range nums {
		sum += v
	}
	for i,v := range nums {
		nums[i] = v * n - sum
	}
	m := n / 2
	vis := map[int]bool{}

	for i := 1;i < (1 << m);i++ {
		cur := 0
		for j,v := range nums[:m] {
			if i & (1 << j) != 0 {
				cur += v
			}
		}
		if cur == 0 {
			return true
		}
		vis[cur] = true
	}

	for i := 1;i < (1 << (n - m));i++ {
		cur := 0
		for j,v := range nums[m:] {
			if i & (1 << j) != 0 {
				cur += v
			}
		}
		if cur == 0 || (i != (1 << (n - m)) -1 && vis[-cur]) {
			return true
		}
	}
	return false
}
