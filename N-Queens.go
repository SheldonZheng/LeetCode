
var res [][]string

func solveNQueens(n int) [][]string {
	res = [][]string{}
	queens := make([]int,n)
	for i := 0;i < n;i++ {
		queens[i] = -1
	}
	columns,ldiag,rdiag := map[int]bool{},map[int]bool{},map[int]bool{}
	backtrack(queens,n,0,columns,ldiag,rdiag)
	return res
}

func backtrack(queens []int,n int,row int,columns,ldiag,rdiag map[int]bool) {
	if row == n {
		pic := generateBoard(queens,n)
		res = append(res,pic)
		return
	}

	for i := 0;i < n;i++ {
		ldiagIdx := row - i
		rdiagIdx := row + i
		if columns[i] || ldiag[ldiagIdx] || rdiag[rdiagIdx] {
			continue
		}

		queens[row] = i
		columns[i],ldiag[ldiagIdx],rdiag[rdiagIdx] = true,true,true
		backtrack(queens,n,row + 1,columns,ldiag,rdiag)
		queens[row] = -1
		delete(columns,i)
		delete(ldiag,ldiagIdx)
		delete(rdiag,rdiagIdx)


	}
}


func generateBoard(queens []int,n int) []string {
	pic := []string{}
	for i := 0;i < n;i++ {
		row := make([]byte,n)
		for j := 0;j < n;j++ {
			row[j] = '.'
		}
		row[queens[i]] = 'Q'
		pic = append(pic,string(row))
	}
	return pic
}
