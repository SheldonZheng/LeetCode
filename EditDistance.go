func minDistance(word1 string, word2 string) int {
	n := len(word1)
	m := len(word2)
	dp := make([][]int,n + 1)
	for i := range dp {
		dp[i] = make([]int,m + 1)
	}

	for i := 0;i <= n;i++ {
		for j := 0;j <= m;j++ {
			if i == 0 {
				dp[i][j] = j
			} else if j == 0 {
				dp[i][j] = i
			} else {
				if word1[i - 1] == word2[j - 1] {
					dp[i][j] = dp[i - 1][j - 1]
				} else {
					dp[i][j] = min(dp[i - 1][j - 1],min(dp[i][j - 1],dp[i - 1][j])) + 1
				}
			}
		}
	}
	return dp[n][m]
}

func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}
