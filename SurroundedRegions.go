
var dire = []int{-1,0,1,0,-1}

func solve(board [][]byte)  {
	m := len(board)
	n := len(board[0])

	if m <= 2 || n <= 2 {
		return 
	}
	vis := make([][]bool,m)
	for i,_ := range vis {
		vis[i] = make([]bool,n)
	}

	var dfs func(int,int)
	dfs = func(i,j int) {
		if i < 0 || j < 0 || i >= m || j >= n {
			return
		}
        if vis[i][j] {
            return
        }
		if board[i][j] != 'O' {
			return
		}

		vis[i][j] = true
		for k := 0;k < 4;k++ {
			ni := i + dire[k]
			nj := j + dire[k + 1]
			dfs(ni,nj)
		}
	}

	for j := 0;j < n;j++ {
		dfs(0,j)
		dfs(m - 1,j)
	}

	for i := 1;i < m - 1;i++ {
		dfs(i,0)
		dfs(i,n - 1)
	}

	for i,iv := range vis {
		for j,jv := range iv {
			if !jv && board[i][j] != 'X' {
				board[i][j] = 'X'
			}
		}
	}
	return 
}
