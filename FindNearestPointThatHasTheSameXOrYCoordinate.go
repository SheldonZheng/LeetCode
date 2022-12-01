func nearestValidPoint(x int, y int, points [][]int) int {
	if points == nil {
		return -1
	}
	minIndex := -1
	minDis := math.MaxInt32
	for i,p := range points {
		if p[0] == x || p[1] == y {
			dis := abs(p[0] - x) + abs(p[1] - y)
			if minDis > dis {
				minIndex = i
				minDis = dis
			}
		}
	}
	return minIndex
}

func abs(v int) int {
	if v < 0 {
		return -v
	}
	return v
}
