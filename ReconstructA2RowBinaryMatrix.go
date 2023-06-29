func reconstructMatrix(upper int, lower int, colsum []int) [][]int {
	n := len(colsum)
	sum := 0
	two := 0
	for _,v := range colsum {
		if v == 2 {
			two++
		}
		sum += v
	}
	if sum != upper + lower || math.Min(float64(upper), float64(lower)) < float64(two) {
		return [][]int{}
	}
	upper -= two
	lower -= two
	res := make([][]int,2)
	for i := 0;i < 2;i++ {
		res[i] = make([]int,n)
	}

	for i := 0;i < n;i++ {
		if colsum[i] == 2 {
			res[0][i],res[1][i] = 1,1
		} else if colsum[i] == 1 {
			if upper > 0 {
				res[0][i] = 1
				upper--
			} else {
				res[1][i] = 1
			}
		}
	}
	return res
}
