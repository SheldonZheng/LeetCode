func wordBreak(s string, wordDict []string) bool {
	n := len(s)
	dp := make([]bool,n + 1)
	dp[0] = true
	for i := 1;i <= n;i++ {
		for _,v := range wordDict {
			if dp[i] {
				break
			}
			len := len(v)
			if i >= len && s[i - len:i] == v {
				dp[i] = dp[i] || dp[i - len]
			}
		}
	}
	return dp[n]
}
