func minimumSize(nums []int, maxOperations int) int {
	max := 0
	for _,v := range nums {
		if v > max {
			max = v
		}
	}
	res := 0
	l := 1
	for l <= max {
		y := (l + max) / 2
		curOps := 0
		for _,v := range nums {
			curOps += (v - 1) / y
		}
		if curOps <= maxOperations {
			res = y
			max = y - 1
		} else {
			l = y + 1
		}
	}
	return res
}
