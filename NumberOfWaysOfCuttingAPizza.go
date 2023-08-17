func ways(pizza []string, k int) int {
	m := len(pizza)
	n := len(pizza[0])
	mod := 1_000_000_007
	apples := make([][]int,m + 1)
	for i := range apples {
		apples[i] = make([]int, n + 1)
	}
	dp := make([][][]int, k + 1)
	for i := range dp {
		dp[i] = make([][]int, m + 1)
		for j := range dp[i] {
			dp[i][j] = make([]int,n + 1)
		}
	}

	for i := m - 1;i >= 0;i-- {
		for j := n - 1;j >= 0;j-- {
			apples[i][j] = apples[i + 1][j] + apples[i][j + 1] - apples[i + 1][j + 1]
			if pizza[i][j] == 'A' {
				apples[i][j] += 1
			}
			if apples[i][j] > 0 {
				dp[1][i][j] = 1
			}
		}
	}

	for kp := 2;kp <= k;kp++ {
		for i := 0;i < m;i++ {
			for j := 0;j < n;j++ {
				for ix := i + 1;ix < m;ix++ {
					if apples[i][j] > apples[ix][j] {
						dp[kp][i][j] = (dp[kp][i][j] + dp[kp - 1][ix][j]) % mod
					}
				}

				for jy := j + 1;jy < n;jy++ {
					if apples[i][j] > apples[i][jy] {
						dp[kp][i][j] = (dp[kp][i][j] + dp[kp - 1][i][jy]) % mod
					}
				}
			}
		}
	}
	return dp[k][0][0]
}
