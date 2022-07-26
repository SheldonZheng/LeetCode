func findMinArrowShots(points [][]int) int {
	if (points == nil || len(points) == 0) {
		return 0
	}

	

	sort.SliceStable(points , func(i,j int) bool {
		return points[i][1] < points[j][1]
	})

	cur := points[0][1]
    needArrows := 1

	for i := 1;i < len(points);i++ {
		if (points[i][0] > cur) {
			needArrows++
			cur = points[i][1]
		}
	}

	return needArrows
}
