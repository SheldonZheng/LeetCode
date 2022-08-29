var dire = []int{-1,0,1,0,-1}

func maxAreaOfIsland(grid [][]int) int {
	if (grid == nil || len(grid) == 0) {
		return 0
	}
	maxArea := 0
	for i := 0;i < len(grid);i++ {
		for j := 0;j < len(grid[i]);j++ {
			if (grid[i][j] == 1) {
				maxArea = max(maxArea,dfs(grid,i,j))
			}
		}
	}
	return maxArea
}

func dfs(grid [][]int,r int ,c int) int {
	grid[r][c] = 0
	x, y, area := 1,1,1
	for i := 0;i < 4;i++ {
		x = r + dire[i]
        y = c + dire[i + 1]
		if (x >= 0 && x < len(grid) && y >= 0 && y < len(grid[r]) && grid[x][y] == 1) {
			area += dfs(grid,x,y)
		}
	}
	return area
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
