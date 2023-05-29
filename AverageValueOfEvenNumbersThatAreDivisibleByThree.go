func averageValue(nums []int) int {
	total := 0
	k := 0
	for _,v := range nums {
		if v % 6 == 0 {
			total += v
			k++
		}
	}

	if k > 0 {
		return total / k
	} else {
		return 0
	}
}
