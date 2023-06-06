func equalPairs(grid [][]int) int {
	res := 0
	for i := range grid {
		for j := range grid {
			ok := 1
			for k := range grid {
				if grid[i][k] != grid[k][j] {
					ok = 0
					break;
				}
			}
			res += ok
		}
	}
	return res
}
