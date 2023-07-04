func matrixSum(nums [][]int) int {
	for _,row := range nums {
		sort.Ints(row)
	}
	
	res := 0
	for i := 0;i < len(nums[0]);i++ {
		curMax := 0
		for _,row := range nums {
			curMax = max(curMax,row[i])
		}
		res += curMax
	}
	return res
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
