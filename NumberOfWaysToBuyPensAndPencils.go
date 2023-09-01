func waysToBuyPensPencils(total int, cost1 int, cost2 int) int64 {
	var res int
	for x := 0;x <= total / cost1;x++ {
		y := (total - x * cost1) / cost2 + 1
		res += y
	}
	return int64(res)
}

