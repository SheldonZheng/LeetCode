func isMatch(s string, p string) bool {
	n := len(s)
	m := len(p)
	matches := func(i,j int) bool {
		if i == 0 {
			return false
		}
		if p[j - 1] == '.' {
			return true
		}
		return s[i - 1] == p[j - 1]
	}

	dp := make([][]bool,n + 1)
	for i := range dp {
		dp[i] = make([]bool,m + 1)
	}
	dp[0][0] = true
	for i := 0;i <= n;i++ {
		for j := 1;j <= m;j++ {
			if p[j - 1] == '*' {
				dp[i][j] = dp[i][j] || dp[i][j - 2]
				if matches(i,j - 1) {
					dp[i][j] = dp[i][j] || dp[i - 1][j]
				}
			} else if matches(i,j) {
				dp[i][j] = dp[i][j] || dp[i - 1][j - 1]
			}
		}
	}
	return dp[n][m]
}
