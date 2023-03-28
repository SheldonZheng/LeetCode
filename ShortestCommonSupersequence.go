func shortestCommonSupersequence(str1 string, str2 string) string {
	m,n := len(str1),len(str2)
	dp := make([][]int,m + 1)
	for i := range dp {
		dp[i] = make([]int,n + 1)
	}
	for i := 1;i <= m;i++ {
		for j := 1;j <= n;j++ {
			if str1[i - 1] == str2[j - 1] {
				dp[i][j] = dp[i - 1][j - 1] + 1
			} else {
				dp[i][j] = max(dp[i - 1][j],dp[i][j - 1])
			}
		}
	}
	res := []byte{}
	i,j := m,n
	for i > 0 || j > 0 {
		if i == 0 {
			j--
			res = append(res,str2[j])
		} else if j == 0 {
			i--
			res = append(res,str1[i])
		} else {
			if dp[i][j] == dp[i - 1][j] {
				i--
				res = append(res,str1[i])
			} else if dp[i][j] == dp[i][j - 1] {
				j--
				res = append(res,str2[j])
			} else {
				i,j = i - 1,j - 1
				res = append(res,str1[i])
			}
		}
	}
	for i,j = 0,len(res) - 1;i < j;i,j = i + 1,j - 1 {
		res[i],res[j] = res[j],res[i]
	}
	return string(res)
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
