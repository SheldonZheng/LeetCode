func stoneGameII(piles []int) int {
	l := len(piles)
	sum := 0
	dp := make([][]int,l)

	for i := range dp {
		dp[i] = make([]int,l + 1)
	}

	for i := l - 1;i >= 0;i-- {
		sum += piles[i]
		for m := 1;m <= l;m++ {
			if (i + 2 * m >= l) {
				dp[i][m] = sum
			} else {
				for x := 1;x <= 2 * m;x++ {
					dp[i][m] = max(dp[i][m],sum - dp[i + x][max(m,x)])
				}
			}
		}
	}
	return dp[0][1]
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
