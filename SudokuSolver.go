func solveSudoku(board [][]byte)  {
	var r,c [9][9]bool
	var block [3][3][9]bool
	var spaces [][2]int

	//init scan
	for i,row := range board {
		for j,b := range row {
			if b == '.' {
				spaces = append(spaces,[2]int{i,j})
			} else {
				//subtract one for store (because array range is 0-8)
				cur := b - '1'
				r[i][cur] = true
				c[j][cur] = true
				block[i / 3][j / 3][cur] = true
			}
		}
	}

	var dfs func(int) bool
	dfs = func(pos int) bool {
		if pos == len(spaces) {
			return true
		}
		i,j := spaces[pos][0],spaces[pos][1]
		for nx := byte(0);nx < 9;nx++ {
			if !r[i][nx] && ! c[j][nx] && !block[i / 3][j / 3][nx] {
				r[i][nx] = true
				c[j][nx] = true
				block[i / 3][j / 3][nx] = true
				board[i][j] = nx + '1'
				if dfs(pos + 1) {
					return true
				}
				r[i][nx] = false
				c[j][nx] = false
				block[i / 3][j / 3][nx] = false
			}
		}
		return false
	}
	dfs(0)
}
