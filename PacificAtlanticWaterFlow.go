
var dire = []int{-1,0,1,0,-1}

func pacificAtlantic(heights [][]int) (res [][]int) {

	p := make([][]bool,len(heights))
	a := make([][]bool,len(heights))
	for i := range p {
		p[i] = make([]bool,len(heights[0]))
		a[i] = make([]bool,len(heights[0]))
	}

	var dfs func([][]bool,int,int) 
	dfs = func(ocean[][] bool,x,y int) {
		if ocean[x][y] {
			return 
		}
		ocean[x][y] = true
		for i := 0;i < 4;i++ {
			nx := x + dire[i]
            ny := y + dire[i + 1]
			if nx >= 0 && nx < len(heights) && ny >= 0 && ny < len(heights[x]) && heights[x][y] <= heights[nx][ny] {
				dfs(ocean,nx,ny)
			}
		}
	}
	for i := 0;i < len(heights);i++ {
		dfs(p,i,0)
		dfs(a,i,len(heights[0]) - 1)
	}

	for j := 0;j < len(heights[0]);j++ {
		dfs(p,0,j)
		dfs(a,len(heights) - 1,j)
	}

	for i,r := range p {
		for j,v := range r {
			if v && a[i][j] {
				res = append(res,[]int{i,j})
			}
		}
	}
	return res

}
