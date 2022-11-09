var dire = []int{-1,0,1,0,-1}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}

func orderOfLargestPlusSign(n int, mines [][]int) int {
	if mines == nil || len(mines) == 0 {
		return n / 2
	}
	vis := make([][]bool,n)
	grid := make([][]int,n)
	for i := range vis {
		vis[i] = make([]bool,n)
		grid[i] = make([]int,n)
		for j := range grid[i] {
			grid[i][j] = 1
		}
	}
	for i := range mines {
		grid[mines[i][0]][mines[i][1]] = 0
	}

	maxRes := 0

	var dfs func(int,int,int) bool
	dfs = func (x,y,level int) bool {
		res := true
		for i := 0;i < 4;i++ {
			nx := x + (dire[i] * level)
            ny := y + (dire[i + 1] * level)
			if nx < 0 || ny < 0 || nx >= n || ny >= n || grid[nx][ny] == 0 {
				res = false
			}
		}
		return res		
	}

	for i := 0;i < n ;i++ {
		for j := 0;j < n ;j++ {
			if grid[i][j] == 1 {
                cur := 1
				for k := 1;k < n / 2 + 1;k++ {
					if dfs(i,j,k) {
						cur = max(k + 1,cur)
					} else {
						break
					}
				}
                maxRes = max(maxRes,cur)
			}
		}
	}

	return maxRes

}
