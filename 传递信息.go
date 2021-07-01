/**
 * LeetCode LCP 07. 传递信息
 */
func numWays(n int,relation [][]int,k int) int {
    dp := make([][]int,k + 1)
    for i := range dp {
        dp[i] = make([]int,n)
    }
    dp[0][0] = 1
    for i := 0;i < k;i++ {
        for _,r := range relation {
            src,dst := r[0],r[1]
            dp[i + 1][dst] += dp[i][src]
        }
    }
    return dp[k][n - 1]
}
