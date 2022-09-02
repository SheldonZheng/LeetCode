func combine(n int, k int) [][]int {
	res := [][]int{}

	temp := []int{}

	var dfs func(int)
	dfs = func(cur int) {
		if len(temp) + (n - cur + 1) < k {
			return 
		}

		if len(temp) == k {
			tempRes := make([]int,k)
			copy(tempRes,temp)
			res = append(res,tempRes)
			return
		}

		temp = append(temp,cur)
		dfs(cur + 1)
		temp = temp[0:len(temp) - 1]
		dfs(cur + 1)
	}
	dfs(1)
	return res
}
