func flipgame(fronts []int, backs []int) int {
	same := make(map[int]bool)
	for i := range fronts {
		if fronts[i] == backs[i] {
			same[fronts[i]] = true
		}
	}

	res := 2100

	for _,x := range fronts {
		if x < res && !same[x] {
			res = x
		}
	}

	for _,x := range backs {
		if x < res && !same[x] {
			res = x
		}
	}
	return res % 2100
}
