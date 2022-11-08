func maxProfit(prices []int, fee int) int {
	if prices == nil || len(prices) == 0 {
		return 0
	}
	cur := prices[0] + fee
	res := 0
	for i := 1;i < len(prices);i++ {
		if prices[i] + fee < cur {
			cur = prices[i] + fee
		} else if prices[i] > cur {
			res += prices[i] - cur
			cur = prices[i]
		}
	}
    return res
}
