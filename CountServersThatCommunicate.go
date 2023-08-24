func countServers(grid [][]int) int {
	n := len(grid)
	m := len(grid[0])

	row := make([]int,n)
	col := make([]int,m)
	
	res := 0
	for i := range grid {
		for j,v := range grid[i] {
			if v == 1 {
				row[i]++
				col[j]++
			}		
			
		}
	}
	for i := range grid {
		for j,v := range grid[i] {
			if v == 1 && (row[i] > 1 || col[j] > 1){
				res++
			}		
			
		}
	}
	return res
}
