func countVowelStrings(n int) int {
	dp := [5]int{}
	for i := 0;i < 5;i++ {
		dp[i] = 1
	}
	for i := 1;i < n;i++ {
		for j := 1;j < 5;j++ {
			dp[j] += dp[j - 1]
		}
	}
	res := 0
	for i := 0;i < 5;i++ {
		res += dp[i]
	}
	return res
}
