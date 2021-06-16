/**
 * LeetCode 877 Stone Game
 */
func stoneGame(piles []int) bool {
	if piles == nil || len(piles) == 0 {
		panic("param error")
	}
	n := len(piles)
	dp := make([][]int, n)
	for i := 0;i < n;i++ {
		dp[i] = make([]int, n)
		dp[i][i] = piles[i]
	}
	for i := n - 2;i >= 0; i-- {
		for j := i + 1;j < n;j++ {
			dp[i][j] = max(piles[i] - dp[i + 1][j],piles[j] - dp[i][j - 1])
		}
	}
	return dp[0][n - 1] > 0

}

func max(x,y int) int {
	if x > y {
		return x
	}
	return y
}
