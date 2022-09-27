func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}

func updateMatrix(mat [][]int) [][]int {
	if mat == nil || len(mat) == 0 {
		return mat
	}
	n := len(mat)
	m := len(mat[0])
	dp := make([][]int,n)
	for i := 0;i < n;i++ {
		dp[i] = make([]int,m)
        for j := 0;j < m;j++ {
            dp[i][j] = 10000
        }
	}

	for i := 0;i < n;i++ {
		for j := 0;j < m;j++ {
			if mat[i][j] == 0 {
				dp[i][j] = 0
			} else {
				if i > 0 {
					dp[i][j] = min(dp[i][j],dp[i - 1][j] + 1)
				}
				if j > 0 {
					dp[i][j] = min(dp[i][j],dp[i][j - 1] + 1)
				}
			}
		}
	}

	for i := n - 1;i >= 0;i-- {
		for j := m - 1;j >= 0;j-- {
			if mat[i][j] != 0 {
				if i < n - 1 {
					dp[i][j] = min(dp[i][j],dp[i + 1][j] + 1)
				}
				if j < m - 1 {
					dp[i][j] = min(dp[i][j],dp[i][j + 1] + 1)
				}			
			} 
		}
	}
	
	return dp
}
