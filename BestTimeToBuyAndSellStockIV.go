func maxProfit(k int, prices []int) int {
	n := len(prices)
	if n < 2 {
		return 0
	}
	buy := make([][]int,n)
	sell := make([][]int,n)
	for i := range sell {
		buy[i] = make([]int, k + 1)
		sell[i] = make([]int,k + 1)
	}
	buy[0][0] = -prices[0]
	for i := 1;i <= k;i++ {
		buy[0][i] = math.MinInt32
		sell[0][i] = math.MinInt32
	}
	
	maxRes := 0
	for i := 1;i < n;i++ {
        buy[i][0] = max(buy[i - 1][0],sell[i - 1][0] - prices[i])
		for j := 1;j <= k;j++ {
			buy[i][j] = max(buy[i - 1][j],sell[i - 1][j] - prices[i])
			sell[i][j] = max(sell[i - 1][j],buy[i - 1][j - 1] + prices[i])
			if i == n - 1 {
                maxRes = max(sell[i][j],maxRes)
            }
		}
	}
	return maxRes
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
