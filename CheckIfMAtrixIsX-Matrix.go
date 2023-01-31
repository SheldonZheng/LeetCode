func checkXMatrix(grid [][]int) bool {
	for i,row := range grid {
		for j,x := range row {
			if (x == 0) == (i == j || i + j == len(grid) - 1) {
				return false
			}
		}
	}
	return true
}
