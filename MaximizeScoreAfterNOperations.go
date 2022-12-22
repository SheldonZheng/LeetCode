func maxScore(nums []int) int {
	m := len(nums)
	g := [14][14]int{}
	for i := 0;i < m;i++ {
		for j := i + 1;j < m;j++ {
			g[i][j] = gcd(nums[i],nums[j])
		}
	}

	dp := make([]int,1 << m)
	for k := 0;k < 1 << m;k++ {
		cnt := bits.OnesCount(uint(k))
		if cnt % 2 == 1 {
			continue
		}
		for i := 0;i < m;i++ {
			if k >> i & 1 == 1 {
				for j := i + 1;j < m;j++ {
					if k >> j & 1 == 1 {
						dp[k] = max(dp[k],dp[k ^ (1 << i) ^ (1 << j)] + (cnt / 2 * g[i][j]))
					}
				}
			}
		}
	}
	return dp[1 << m - 1]
}

func gcd(a,b int) int {
	if b == 0 {
		return a
	}
	return gcd(b,a % b)
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
