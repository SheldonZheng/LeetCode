
var dire = []int{-1,0,1,0,-1}

func shortestBridge(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	queue := make([][]int,0)

	var  dfsFindIsland func(int,int)
	dfsFindIsland = func(i,j int) {
		if i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 2 {
			return
		}
		if grid[i][j] == 0 {
			queue = append(queue,[]int{i,j})
		} else if grid[i][j] == 1 {
			grid[i][j] = 2
			for p := 0;p < 4;p++ {
				nx := i + dire[p]
				ny := j + dire[p + 1]
				dfsFindIsland(nx,ny)
			}
		}
	}

	var bfsFindBridge func()int
	bfsFindBridge = func() int {
		res := 0
		for len(queue) > 0 {
			res++
			j := len(queue) - 1
			for ;j >= 0;j-- {
				x := queue[0][0]
				y := queue[0][1]
				// pop
				queue = queue[1:]
				for i := 0;i < 4;i++ {
					nx := x + dire[i]
					ny := y + dire[i + 1]
					if nx >= 0 && ny >= 0 && nx < m && ny < n {
						if grid[nx][ny] == 1 {
							return res
						} else if grid[nx][ny] == 2 {
							continue
						}
						queue = append(queue,[]int{nx,ny})
						grid[nx][ny] = 2
					}
				}
			}
		}
		return res
	}


	findFirst := true
	for i := 0;i < m && findFirst;i++ {
		for j := 0;j < n;j++ {
			if grid[i][j] == 1 {
				dfsFindIsland(i,j)
				findFirst = false
				break;
			}
		}
	}

	return bfsFindBridge()
}


