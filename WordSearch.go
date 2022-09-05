var dire = []int{-1,0,1,0,-1}


func exist(board [][]byte, word string) bool {

	k := len(word)

	h := len(board)
	w := len(board[0])

	res := false

	visited := make([][]bool,h)

	for i := range visited {
		visited[i] = make([]bool,w)
	}


	var backtrack func(int,int,int)
	backtrack = func(i int,j int,pos int) {

		if i < 0 || j < 0 || i >= h || j >= w {
			return
		}

		if visited[i][j] || res || board[i][j] != word[pos] {
			return
		}

		if pos == k - 1 {
			res = true
			return
		}
		visited[i][j] = true
		for x := 0;x < 4;x++ {
			ni := i + dire[x]
            nj := j + dire[x + 1]
		 	backtrack(ni,nj,pos + 1)
		}
		visited[i][j] = false
	}

	for i := 0;i < h;i++ {
		for j := 0;j < w;j++ {
			backtrack(i,j,0)
		}
	}
	return res
}
